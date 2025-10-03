package com.alidev.ecommerceapplication.presentation.signin

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alidev.ecommerceapplication.domain.SaveUser
import com.alidev.ecommerceapplication.domain.UseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class SignInViewModel @Inject constructor(
    private val useCases: UseCases
) : ViewModel() {

    data class SignInUiState(
        val isLoading: Boolean = false,
        val isSuccess: Boolean = false,
        val errorMessage: String? = null
    )

    private val _uiState: MutableStateFlow<SignInUiState> = MutableStateFlow(SignInUiState())
    val uiState: StateFlow<SignInUiState> = _uiState.asStateFlow()

    suspend fun checkUser(email: String, password:String): com.alidev.ecommerceapplication.domain.SaveUser? {
        _uiState.value = SignInUiState(isLoading = true)
        val user = useCases.getUser.invoke(email, password)
        _uiState.value = if (user != null) {
            SignInUiState(isLoading = false, isSuccess = true, errorMessage = null)
        } else {
            SignInUiState(isLoading = false, isSuccess = false, errorMessage = "Invalid email or password.")
        }
        return user
    }



}