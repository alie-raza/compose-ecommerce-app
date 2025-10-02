package com.alidev.ecommerceapplication.presentation.signin
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.alidev.ecommerceapplication.presentation.component.DefaultBackArrow
import com.alidev.ecommerceapplication.ui.theme.TextColor

@Composable
fun SignInScreen(navController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(30.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {

            Box(modifier = Modifier.weight(0.7f)) {
                DefaultBackArrow(navController = navController)
            }

            Box(modifier = Modifier.weight(1f)) {
                Text(text = "Sign in", color = TextColor, fontSize = 18.sp)
            }
        }
        Spacer(modifier = Modifier.height(50.dp))
        Text(text = "Welcome Back", fontSize = 26.sp, fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.height(10.dp))
        Text(
            text = "Sign in with your email or password\nor continue with social media.",
            color = TextColor,
            textAlign = TextAlign.Center
        )

    }
}


@Preview(showBackground = true)
@Composable
fun OnSignInScreenPreview() {
    val navController = rememberNavController()
    SignInScreen(navController = navController)
}