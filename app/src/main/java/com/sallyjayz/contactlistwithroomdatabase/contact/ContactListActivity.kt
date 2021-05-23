package com.sallyjayz.contactlistwithroomdatabase.contact

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.sallyjayz.contactlistwithroomdatabase.ContactsApplication
import com.sallyjayz.contactlistwithroomdatabase.R
import com.sallyjayz.contactlistwithroomdatabase.adapter.ContactListAdapter
import com.sallyjayz.contactlistwithroomdatabase.model.Contact

class ContactListActivity : AppCompatActivity() {

    private val newContactActivityRequestCode = 1

    private val contactViewModel: ContactViewModel by viewModels  {
        ContactViewModelFactory((application as ContactsApplication).contactRepository)
    }



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contact_list)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerview)
        val adapter = ContactListAdapter()
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)

        contactViewModel.allContacts.observe(this, Observer { contacts ->
            // Update the cached copy of the words in the adapter.
            contacts?.let { adapter.submitList(it) }
        })

        val fab = findViewById<FloatingActionButton>(R.id.fab)
        fab.setOnClickListener {
            val intent = Intent(this@ContactListActivity, AddContactActivity::class.java)
            startActivityForResult(intent, newContactActivityRequestCode)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == newContactActivityRequestCode && resultCode == Activity.RESULT_OK) {
            /*data?.getStringExtra(NewContactActivity.EXTRA_NAME)?.let {
                val contact = Contact(it)
                contactViewModel.insert(contact)
            }*/
            data?.getStringArrayExtra(AddContactActivity.EXTRA_VALUES)?.let {
                val contact = Contact(it[0], it[1])
                contactViewModel.insert(contact)
            }
        } else {
            Toast.makeText(
                applicationContext,
                R.string.empty_not_saved,
                Toast.LENGTH_LONG).show()
        }
    }
}