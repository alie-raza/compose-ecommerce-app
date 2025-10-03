package com.alidev.ecommerceapplication.presentation.signup

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.alidev.ecommerceapplication.R
import com.alidev.ecommerceapplication.domain.SaveUser
import com.alidev.ecommerceapplication.navigation.screen.Screen
import com.alidev.ecommerceapplication.presentation.component.CustomTextField
import com.alidev.ecommerceapplication.presentation.component.DefaultBackArrow
import com.alidev.ecommerceapplication.presentation.component.ErrorSuggestion
import com.alidev.ecommerceapplication.presentation.signin.SignInScreen
import com.alidev.ecommerceapplication.ui.theme.DIMENS_16dp
import com.alidev.ecommerceapplication.ui.theme.DIMENS_40dp
import com.alidev.ecommerceapplication.ui.theme.GilroyFontFamily
import com.alidev.ecommerceapplication.ui.theme.Orange
import com.alidev.ecommerceapplication.ui.theme.PrimaryLightColor
import com.alidev.ecommerceapplication.ui.theme.TEXT_SIZE_18sp
import com.alidev.ecommerceapplication.ui.theme.TextColor

@Composable
fun SignUpScreen(
    navController: NavHostController,
    saveUserViewModel: SaveUserViewModel = hiltViewModel()
) {

    val context = LocalContext.current

    var email by remember { mutableStateOf(TextFieldValue("")) }

    var password by remember { mutableStateOf(TextFieldValue("")) }

    var confirmPassword by remember { mutableStateOf(TextFieldValue("")) }


    val emailErrorState = remember {
        mutableStateOf(false)
    }
    val passwordErrorState = remember {
        mutableStateOf(false)
    }

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
                Text(text = "Sign Up", color = TextColor, fontSize = 18.sp)
            }
        }
        Spacer(modifier = Modifier.height(30.dp))
        Text(text = "Register Account", fontSize = 26.sp, fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.height(10.dp))
        Text(
            text = "Complete your details or continue\nwith social media.",
            color = TextColor,
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(50.dp))

        CustomTextField(
            placeholder = "example@email.com",
            trailingIcon = R.drawable.mail,
            label = "Email",
            errorState = emailErrorState,
            keyboardType = KeyboardType.Email,
            visualTransformation = VisualTransformation.None,
            onChanged = { newEmail ->
                email = newEmail
            }
        )

        Spacer(modifier = Modifier.height(20.dp))

        CustomTextField(
            placeholder = "example@email.com",
            trailingIcon = R.drawable.lock,
            label = "Password",
            errorState = passwordErrorState,
            keyboardType = KeyboardType.Password,
            visualTransformation = PasswordVisualTransformation(),
            onChanged = { pass ->
                password = pass
            }
        )

        Spacer(modifier = Modifier.height(20.dp))


        CustomTextField(
            placeholder = "example@email.com",
            trailingIcon = R.drawable.lock,
            label = "Confirm Password",
            errorState = passwordErrorState,
            keyboardType = KeyboardType.Password,
            visualTransformation = PasswordVisualTransformation(),
            onChanged = { pass ->
                confirmPassword = pass
            }
        )
        Spacer(modifier = Modifier.height(10.dp))

        if (emailErrorState.value) {
            ErrorSuggestion("Please enter valid email address.")
        }

        if (passwordErrorState.value) {
            ErrorSuggestion("Please enter valid password.")
        }

        Spacer(modifier = Modifier.height(30.dp))

        Button(
            onClick = {
                if(email.text.isNotEmpty()&&password.text.isNotEmpty()&&confirmPassword.text.isNotEmpty()){
                    val user = SaveUser(0,"","",email.text.trim(),password.text.trim(),123,"",true)
                    saveUserViewModel.saveUser(user)

                    Toast.makeText(context,"User saved",Toast.LENGTH_SHORT).show()
                }
//                navController.navigate(Screen.CompleteScreen.route)
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(DIMENS_40dp)
                .padding(horizontal = DIMENS_16dp),
            colors = ButtonDefaults.buttonColors(backgroundColor = Orange),
            shape = RoundedCornerShape(DIMENS_40dp),
        ) {
            Text(
                text = "Continue",
                fontFamily = GilroyFontFamily,
                fontWeight = FontWeight.SemiBold,
                fontSize = TEXT_SIZE_18sp,
                color = Color.White
            )
        }

        Column(
            modifier = Modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.Bottom
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(
                    space = 10.dp,
                    alignment = Alignment.CenterHorizontally
                )
            ) {
                Box(
                    modifier = Modifier
                        .size(50.dp)
                        .background(
                            PrimaryLightColor,
                            shape = CircleShape
                        ),
                    contentAlignment = Alignment.Center
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.google_icon),
                        contentDescription = "Google Login Icon"
                    )
                }
                Box(
                    modifier = Modifier
                        .size(50.dp)
                        .background(
                            PrimaryLightColor,
                            shape = CircleShape
                        )
                        .clickable {

                        },
                    contentAlignment = Alignment.Center,
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.twitter),
                        contentDescription = "Twitter Login Icon"
                    )
                }
                Box(
                    modifier = Modifier
                        .size(50.dp)
                        .background(
                            PrimaryLightColor,
                            shape = CircleShape
                        )
                        .clickable {

                        },
                    contentAlignment = Alignment.Center
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.facebook_2),
                        contentDescription = "Facebook Login Icon"
                    )
                }

            }
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 30.dp)
                    .clickable {

                    },
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "By continuing you confirm that you agree",
                    color = TextColor
                )
                Row()
                {
                    Text(
                        text = "with our ",
                        color = TextColor,
                    )
                    Text(
                        text = "Terms & Condition",
                        color = Orange,
                        modifier = Modifier.clickable {

                        })
                }

            }
        }


    }

}

@Preview(showBackground = true)
@Composable
fun SignUpScreenPreview() {
    val navController = rememberNavController()
    SignUpScreen(navController = navController)
}

