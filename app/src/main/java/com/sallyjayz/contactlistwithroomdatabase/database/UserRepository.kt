package com.sallyjayz.contactlistwithroomdatabase.database

import androidx.annotation.WorkerThread
import com.sallyjayz.contactlistwithroomdatabase.model.Contact
import com.sallyjayz.contactlistwithroomdatabase.model.User
import kotlinx.coroutines.flow.Flow

class UserRepository (private val userDao: UserDao) {

    fun findFilledEmailPassword(email: String, password: String):Int {
        return userDao.findByEmailPassword(email, password)
    }

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun insert(user: User) {
        userDao.insert(user)
    }
}