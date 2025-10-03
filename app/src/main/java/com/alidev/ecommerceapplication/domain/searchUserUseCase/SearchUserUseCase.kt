package com.alidev.ecommerceapplication.domain.searchUserUseCase

import com.alidev.ecommerceapplication.data.Repository

class SearchUserUseCase(
    private val repository: Repository
) {
    suspend operator fun invoke(email: String, password:String) = repository.searchUser(email,password)

}