package com.alidev.ecommerceapplication.data

import com.alidev.ecommerceapplication.domain.LocalDataSource
import com.alidev.ecommerceapplication.domain.SaveUser
import com.alidev.ecommerceapplication.local.ProductDatabase
import kotlinx.coroutines.flow.Flow

class LocalDataSourceImpl(
    productDatabase: ProductDatabase
) : LocalDataSource {
    private val productDao = productDatabase.productDao()
    override suspend fun saveUser(user: SaveUser) = productDao.saveUser(user)
    override suspend fun searchUser(email: String, password:String): SaveUser? =  productDao.loginUser(email,password)

}