package com.sallyjayz.contactlistwithroomdatabase.database

import androidx.annotation.WorkerThread
import com.sallyjayz.contactlistwithroomdatabase.model.Contact
import kotlinx.coroutines.flow.Flow

class ContactRepository(private val contactDao: ContactDao) {

    val allContacts: Flow<List<Contact>> = contactDao.getAlphabetizedContacts()

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun insert(contact: Contact) {
        contactDao.insert(contact)
    }
}