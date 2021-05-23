package com.sallyjayz.contactlistwithroomdatabase

import android.app.Application
import com.sallyjayz.contactlistwithroomdatabase.database.ContactRepository
import com.sallyjayz.contactlistwithroomdatabase.database.ContactRoomDatabase
import com.sallyjayz.contactlistwithroomdatabase.database.UserRepository

class ContactsApplication : Application() {
    // Using by lazy so the database and the repository are only created when they're needed
    // rather than when the application starts
    val database by lazy { ContactRoomDatabase.getDatabase(this) }
    val contactRepository by lazy { ContactRepository(database.contactDao()) }
    val userrepository by lazy { UserRepository(database.userDao()) }
}