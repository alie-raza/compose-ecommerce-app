package com.alidev.ecommerceapplication.data

import com.alidev.ecommerceapplication.domain.LocalDataSource
import com.alidev.ecommerceapplication.domain.SaveUser
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class Repository @Inject constructor(
    private val localDataSource: LocalDataSource
) {

    suspend fun saveUser(saveUser: SaveUser) = localDataSource.saveUser(saveUser)

    suspend fun searchUser(email: String, password:String): SaveUser? = localDataSource.searchUser(email,password)


}