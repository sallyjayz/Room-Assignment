package com.sallyjayz.contactlistwithroomdatabase.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName="user_table")
data class User(
    @PrimaryKey
    @ColumnInfo(name = "user_email")
    val email: String,
    @ColumnInfo(name = "user_password")
    val password:String
)