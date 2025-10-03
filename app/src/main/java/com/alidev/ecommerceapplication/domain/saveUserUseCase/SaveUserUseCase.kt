package com.alidev.ecommerceapplication.domain.saveUserUseCase

import com.alidev.ecommerceapplication.data.Repository
import com.alidev.ecommerceapplication.domain.SaveUser

class SaveUserUseCase(
    private val repository: Repository
) {

    suspend operator fun invoke(saveUser: SaveUser) = repository.saveUser(saveUser)
}