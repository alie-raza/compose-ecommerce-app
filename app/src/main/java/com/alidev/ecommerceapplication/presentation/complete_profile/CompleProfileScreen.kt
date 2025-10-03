package com.alidev.ecommerceapplication.presentation.complete_profile


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
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
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
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.alidev.ecommerceapplication.R
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
fun CompleteProfileScreen(navController: NavHostController) {

    var firstName by remember { mutableStateOf(TextFieldValue("")) }

    var lastName by remember { mutableStateOf(TextFieldValue("")) }

    var phoneNumber by remember { mutableStateOf(TextFieldValue("")) }

    var address by remember { mutableStateOf(TextFieldValue("")) }


    val firstNameErrorState = remember {
        mutableStateOf(false)
    }

    val lastNameErrorState = remember {
        mutableStateOf(false)
    }

    val phoneNumberErrorState = remember {
        mutableStateOf(false)
    }

    val addressErrorState = remember {
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
        Text(text = "Complete Profile", fontSize = 26.sp, fontWeight = FontWeight.Bold)
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
            label = "First Name",
            errorState = firstNameErrorState,
            keyboardType = KeyboardType.Text,
            visualTransformation = VisualTransformation.None,
            onChanged = { fn ->
                firstName = fn
            }
        )

        Spacer(modifier = Modifier.height(20.dp))

        CustomTextField(
            placeholder = "example@email.com",
            trailingIcon = R.drawable.lock,
            label = "Last Name",
            errorState = lastNameErrorState,
            keyboardType = KeyboardType.Text,
            visualTransformation = VisualTransformation.None,
            onChanged = { ln ->
                lastName = ln
            }
        )

        Spacer(modifier = Modifier.height(20.dp))


        CustomTextField(
            placeholder = "example@email.com",
            trailingIcon = R.drawable.lock,
            label = "Phone Number",
            errorState = phoneNumberErrorState,
            keyboardType = KeyboardType.Number,
            visualTransformation = PasswordVisualTransformation(),
            onChanged = { pn ->
                phoneNumber = pn
            }
        )
        Spacer(modifier = Modifier.height(10.dp))

        CustomTextField(
            placeholder = "example@email.com",
            trailingIcon = R.drawable.lock,
            label = "Address",
            errorState = phoneNumberErrorState,
            keyboardType = KeyboardType.Text,
            visualTransformation = VisualTransformation.None,
            onChanged = { ad ->
                address = ad
            }
        )


//        if (emailErrorState.value) {
//            ErrorSuggestion("Please enter valid email address.")
//        }
//
//        if(passwordErrorState.value){
//            ErrorSuggestion("Please enter valid password.")
//        }

        Spacer(modifier = Modifier.height(40.dp))

        Button(
            onClick = {

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
                .fillMaxSize()
                .padding(bottom = 50.dp),
            verticalArrangement = Arrangement.Bottom
        ) {
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
    CompleteProfileScreen(navController = navController)
}

