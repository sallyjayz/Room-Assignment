package com.sallyjayz.contactlistwithroomdatabase.user

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.google.android.material.textfield.TextInputEditText
import com.sallyjayz.contactlistwithroomdatabase.ContactsApplication
import com.sallyjayz.contactlistwithroomdatabase.R
import com.sallyjayz.contactlistwithroomdatabase.contact.ContactListActivity

class LoginActivity : AppCompatActivity() {

    private lateinit var editEmailView: TextInputEditText
    private lateinit var editPasswordView: TextInputEditText

    private val userViewModel: UserViewModel by viewModels  {
        UserViewModelFactory((application as ContactsApplication).userrepository)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        editEmailView = findViewById(R.id.email)
        editPasswordView = findViewById(R.id.password)

        val button = findViewById<Button>(R.id.login_btn)

        button.setOnClickListener {

            val email = editEmailView.text.toString()
            val password = editPasswordView.text.toString()

            if (email.isNotEmpty() || password.isNotEmpty()) {
                userViewModel.findFilledEmailPassword(email, password)
                userViewModel.count.observe(this, Observer {
                    if (it > 0) {
                        val intent = Intent(this, ContactListActivity::class.java)
                        startActivity(intent)
                    } else {
                        Toast.makeText(this, "Email does not exist",
                                Toast.LENGTH_SHORT).show()
                        val intent = Intent(this, SignupActivity::class.java)
                        startActivity(intent)
                    }

                })
            } else {
                Toast.makeText(this, "Email or password cannot be empty",
                        Toast.LENGTH_SHORT).show()
            }



            /*val userCount = userViewModel.findFilledEmailPassword(email, password)*/

            /*if(userCount > 0) {
                Toast.makeText(this, "Email or Password Exist",
                    Toast.LENGTH_SHORT).show()
                val intent = Intent(this, SignupActivity::class.java)
                startActivity(intent)
            } else {
                val intent = Intent(this, ContactListActivity::class.java)
                startActivity(intent)
            }*/

            /*if(email.isNotBlank() && password.isNotBlank()) {
                userViewModel.findFilledEmailPassword(email, password)
                val intent = Intent(this, ContactListActivity::class.java)
                startActivity(intent)
            } else {
                val intent = Intent(this, SignupActivity::class.java)
                startActivity(intent)
            }*/


            /*userViewModel.findFilledEmailPassword(email, password).let {
                if (email == it.toString()) {
                    val intent = Intent(this, ContactListActivity::class.java)
                    startActivity(intent)
                } else {
                    val intent = Intent(this, SignupActivity::class.java)
                    startActivity(intent)
                }
            }*/
        }
    }
}