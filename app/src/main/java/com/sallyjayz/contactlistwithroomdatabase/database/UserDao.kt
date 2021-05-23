package com.sallyjayz.contactlistwithroomdatabase.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.sallyjayz.contactlistwithroomdatabase.model.User
import kotlinx.coroutines.flow.Flow

@Dao
interface UserDao {
    @Query("SELECT COUNT(user_email) FROM user_table WHERE user_email = :email AND user_password = :password")
    fun findByEmailPassword(email:String, password:String): Int

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(user: User)

}