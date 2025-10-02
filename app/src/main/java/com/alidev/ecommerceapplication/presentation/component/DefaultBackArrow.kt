package com.alidev.ecommerceapplication.presentation.component

import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import com.alidev.ecommerceapplication.ui.theme.Black

@Composable
fun DefaultBackArrow(
    navController: NavHostController,
    tint: Color = Black
) {
    IconButton(
        onClick = { navController.popBackStack() }
    ) {
        Icon(
            imageVector = Icons.Filled.ArrowBack,
            contentDescription = "Back",
            tint = tint
        )
    }
}
