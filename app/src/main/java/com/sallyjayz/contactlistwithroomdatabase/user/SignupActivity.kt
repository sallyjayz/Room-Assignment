package com.sallyjayz.contactlistwithroomdatabase.user

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.google.android.material.textfield.TextInputEditText
import com.sallyjayz.contactlistwithroomdatabase.ContactsApplication
import com.sallyjayz.contactlistwithroomdatabase.R
import com.sallyjayz.contactlistwithroomdatabase.contact.ContactListActivity
import com.sallyjayz.contactlistwithroomdatabase.contact.ContactViewModel
import com.sallyjayz.contactlistwithroomdatabase.contact.ContactViewModelFactory
import com.sallyjayz.contactlistwithroomdatabase.model.User

class SignupActivity : AppCompatActivity() {

    private lateinit var editEmailView: TextInputEditText
    private lateinit var editPasswordView: TextInputEditText

    private val userViewModel: UserViewModel by viewModels  {
        UserViewModelFactory((application as ContactsApplication).userrepository)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        editEmailView = findViewById(R.id.email)
        editPasswordView = findViewById(R.id.password)

        val button = findViewById<Button>(R.id.signup_btn)

        button.setOnClickListener {

            /*val email = editEmailView.text.toString()
            val password = editPasswordView.text.toString()

            val databaseEmail = userViewModel.findFilledEmail(email)
            if (email != databaseEmail.toString()) {
                val user = User(email, password)
                userViewModel.insert(user)
                val intent = Intent(this, LoginActivity::class.java)
                startActivity(intent)
            } else {
                Toast.makeText(this, "Email already in use",
                    Toast.LENGTH_SHORT).show()
            }*/

            val email = editEmailView.text.toString()
            val password = editPasswordView.text.toString()

            if (email.isNotEmpty() || password.isNotEmpty()) {
//                userViewModel.findFilledEmailPassword(email, password)
                val user = User(email, password)
                userViewModel.insert(user)
                val intent = Intent(this, LoginActivity::class.java)
                startActivity(intent)
            } else {
                Toast.makeText(this, "Email or password cannot be empty",
                        Toast.LENGTH_SHORT).show()
            }

//            userViewModel.countGreaterThanZero.observe(this, Observer {
//
//                /*val user = User(email, password)
//                userViewModel.insert(user)
//                val intent = Intent(this, LoginActivity::class.java)
//                startActivity(intent)
//
//                Log.d("Userviewmodel", "findFilledEmailPassword: $it")*/
//
//                if (it == true) {
//                    Toast.makeText(this, "Email or Password Exist",
//                        Toast.LENGTH_SHORT).show()
//                    val intent = Intent(this, LoginActivity::class.java)
//                    startActivity(intent)
//                } else {
//                    val user = User(email, password)
//                    userViewModel.insert(user)
//                    val intent = Intent(this, LoginActivity::class.java)
//                    startActivity(intent)
//                }
//
//            })


            /*if(userCount > 0) {
                val intent = Intent(this, LoginActivity::class.java)
                startActivity(intent)
            } else {
                val user = User(email, password)
                userViewModel.insert(user)
                val intent = Intent(this, LoginActivity::class.java)
                startActivity(intent)
            }*/

            /*val email = editEmailView.text.toString()
            val password = editPasswordView.text.toString()

            val user = User(email, password)
            userViewModel.insert(user)*/
        }
    }
}