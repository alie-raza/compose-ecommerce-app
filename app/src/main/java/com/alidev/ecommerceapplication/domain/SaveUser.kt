package com.alidev.ecommerceapplication.domain

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.alidev.ecommerceapplication.utils.Constants.USER_DATABASE_TABLE

@Entity(tableName = USER_DATABASE_TABLE)
data class SaveUser(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val firstName: String,
    val lastName: String,
    val email: String,
    val password: String,
    val phoneNumber: Int,
    val address: String,
    val isUserLogin: Boolean = false
)
