package com.sallyjayz.contactlistwithroomdatabase.contact

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextUtils
import android.text.TextWatcher
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputEditText
import com.sallyjayz.contactlistwithroomdatabase.R

class AddContactActivity : AppCompatActivity() {

    private lateinit var editNameView: TextInputEditText
    private lateinit var editNumberView: TextInputEditText

    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_contact)
        editNameView = findViewById(R.id.nameEt)
        editNumberView = findViewById(R.id.numberEt)

        val button = findViewById<Button>(R.id.saveBt)

        editNumberView.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                button.isEnabled = s?.length == 11
            }

            override fun afterTextChanged(s: Editable?) {

            }

        })

        button.setOnClickListener {
            val replyIntent = Intent()
            if (TextUtils.isEmpty(editNameView.text) || TextUtils.isEmpty(editNumberView.text)) {
                setResult(Activity.RESULT_CANCELED, replyIntent)
            } else {
                val name = editNameView.text.toString()
                val number = editNumberView.text.toString()
                replyIntent.putExtra(EXTRA_VALUES, arrayOf(name, number))
//                replyIntent.putExtra(EXTRA_NAME, name)
//                replyIntent.putExtra(EXTRA_NUMBER, number)
                setResult(Activity.RESULT_OK, replyIntent)
            }
            finish()
        }
    }

    companion object {
//        const val EXTRA_NAME = "com.sallyjayz.contactlistwithroomdatabase.NAME"
//        const val EXTRA_NUMBER = "com.sallyjayz.contactlistwithroomdatabase.NUMBER"

        const val EXTRA_VALUES = "com.sallyjayz.contactlistwithroomdatabase.VALUES"
    }
}