package com.alidev.ecommerceapplication.data

import com.alidev.ecommerceapplication.domain.LocalDataSource
import com.alidev.ecommerceapplication.domain.SaveUser
import javax.inject.Inject

class Repository@Inject constructor(
    private val localDataSource: LocalDataSource
) {

    suspend fun saveUser(saveUser: SaveUser) = localDataSource.saveUser(saveUser)


}