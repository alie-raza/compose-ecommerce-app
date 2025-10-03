package com.alidev.ecommerceapplication.presentation.signup

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alidev.ecommerceapplication.domain.SaveUser
import com.alidev.ecommerceapplication.domain.UseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject
@HiltViewModel
class SaveUserViewModel @Inject constructor(
    private val useCases: UseCases
) : ViewModel() {

    fun saveUser(saveUser: SaveUser) = viewModelScope.launch {
        useCases.saveUser.invoke(saveUser)
    }


}