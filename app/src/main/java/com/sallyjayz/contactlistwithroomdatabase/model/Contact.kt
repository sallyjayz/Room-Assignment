package com.sallyjayz.contactlistwithroomdatabase.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName="contact_table")
data class Contact(
        @PrimaryKey
        @ColumnInfo(name = "contact_name")
        val name: String,
        @ColumnInfo(name = "contact_phone")
        val number:String
)
