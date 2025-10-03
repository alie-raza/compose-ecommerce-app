package com.alidev.ecommerceapplication.local.dao

import androidx.room.*
import com.alidev.ecommerceapplication.domain.SaveUser
import com.alidev.ecommerceapplication.utils.Constants.USER_DATABASE_TABLE
import kotlinx.coroutines.flow.Flow


@Dao
interface ProductDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveUser(saveUser: SaveUser)

    @Query("SELECT * FROM $USER_DATABASE_TABLE WHERE email = :email AND password = :password LIMIT 1")
    suspend fun loginUser(email: String, password: String): SaveUser?

}