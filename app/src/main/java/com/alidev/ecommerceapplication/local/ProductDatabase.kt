package com.alidev.ecommerceapplication.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.alidev.ecommerceapplication.domain.SaveUser
import com.alidev.ecommerceapplication.local.dao.ProductDao

@Database(entities = [SaveUser::class], version = 2)
abstract class ProductDatabase : RoomDatabase() {

    abstract fun productDao(): ProductDao

}