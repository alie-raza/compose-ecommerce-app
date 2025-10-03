
package com.alidev.ecommerceapplication.domain

import kotlinx.coroutines.flow.Flow

interface LocalDataSource {

    suspend fun saveUser(user: SaveUser)

}