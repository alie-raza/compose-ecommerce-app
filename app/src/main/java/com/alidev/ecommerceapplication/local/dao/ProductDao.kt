package com.alidev.ecommerceapplication.local.dao

import androidx.room.*
import com.alidev.ecommerceapplication.domain.SaveUser


@Dao
interface ProductDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveUser(saveUser: SaveUser)


}