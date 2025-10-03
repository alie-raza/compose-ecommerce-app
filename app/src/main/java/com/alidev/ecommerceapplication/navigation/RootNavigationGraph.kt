package com.alidev.ecommerceapplication.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.alidev.ecommerceapplication.navigation.screen.Screen
import com.alidev.ecommerceapplication.presentation.SplashScreen
import com.alidev.ecommerceapplication.presentation.complete_profile.CompleteProfileScreen
import com.alidev.ecommerceapplication.presentation.signin.SignInScreen
import com.alidev.ecommerceapplication.presentation.signup.SignUpScreen

@Composable
fun RootNavigationGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        route = Graph.ROOT,
        startDestination = Screen.Splash.route
    ) {

        composable(route = Screen.Splash.route) {
            SplashScreen(navController = navController)
        }

        composable(route = Screen.SignIn.route) {
            SignInScreen(navController = navController)
        }

        composable(route = Screen.SignUp.route) {
            SignUpScreen(navController = navController)
        }

        composable(route = Screen.CompleteScreen.route) {
            CompleteProfileScreen(navController = navController)
        }
//
//        composable(route = Graph.MAIN) {
//            MainScreen()
//        }
    }
}