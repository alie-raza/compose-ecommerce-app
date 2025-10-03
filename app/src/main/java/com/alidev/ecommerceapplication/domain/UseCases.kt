package com.alidev.ecommerceapplication.domain


import com.alidev.ecommerceapplication.domain.saveUserUseCase.SaveUserUseCase
import javax.inject.Inject

data class UseCases @Inject constructor(
    val saveUser: SaveUserUseCase,

)