package com.alidev.ecommerceapplication.domain


import com.alidev.ecommerceapplication.domain.saveUserUseCase.SaveUserUseCase
import com.alidev.ecommerceapplication.domain.searchUserUseCase.SearchUserUseCase
import javax.inject.Inject

data class UseCases @Inject constructor(
    val saveUser: SaveUserUseCase,
    val getUser: SearchUserUseCase,
)