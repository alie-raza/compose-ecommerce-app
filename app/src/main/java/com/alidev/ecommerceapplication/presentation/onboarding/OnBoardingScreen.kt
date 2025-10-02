package com.alidev.ecommerceapplication.presentation.onboarding

import android.R.attr.onClick
import android.annotation.SuppressLint
import android.graphics.Color
import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.animation.with
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Colors
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.Green
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.alidev.ecommerceapplication.R
import com.alidev.ecommerceapplication.presentation.component.DotIndicator
import com.alidev.ecommerceapplication.ui.theme.DIMENS_12dp
import com.alidev.ecommerceapplication.ui.theme.DIMENS_16dp
import com.alidev.ecommerceapplication.ui.theme.DIMENS_68dp
import com.alidev.ecommerceapplication.ui.theme.GilroyFontFamily
import com.alidev.ecommerceapplication.ui.theme.TEXT_SIZE_18sp
import com.google.accompanist.pager.rememberPagerState

@SuppressLint("UnusedContentLambdaTargetStateParameter")
@OptIn(ExperimentalAnimationApi::class)
@Composable
fun OnBoardingScreen(
    navController: NavHostController,
){
    val splashImageList = listOf(
        R.drawable.splash_1,
        R.drawable.splash_2,
        R.drawable.splash_3,
    )
    val currentPosition = remember { mutableStateOf(0) }
    val animate = remember { mutableStateOf(true) }
    val pagerState = rememberPagerState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(30.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceAround
    ) {
        AnimatedContent(
            targetState = animate.value,
            modifier = Modifier
                .fillMaxWidth(),
            transitionSpec = {
                slideInHorizontally(
                    initialOffsetX = { value ->
                        value
                    }
                ) with slideOutHorizontally(
                    targetOffsetX = { value ->
                        -value
                    }
                )
            },
            content = {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight(0.6f)
                        .padding(top = 10.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                    Text(
                        text = "JEXMON",
                        fontSize = 50.sp,
                        color = MaterialTheme.colors.primary,
                        fontWeight = FontWeight.Bold,
                        fontFamily = GilroyFontFamily,
                    )
                    Spacer(modifier = Modifier.height(5.dp))
                    when (currentPosition.value) {
                        0 -> {
                            Text(
                                text = buildAnnotatedString {
                                    append(text = "Welcome to ")
                                    withStyle(
                                        style = SpanStyle(
                                            fontWeight = FontWeight.Bold,
                                            color = androidx.compose.ui.graphics.Color.Cyan,
                                        )
                                    ) {
                                        append("Jexmon.")
                                    }
                                    append(" Let's Shop!")
                                },
                                color = androidx.compose.ui.graphics.Color.Cyan,
                                fontSize = 18.sp,
                                textAlign = TextAlign.Center,
                                fontFamily = GilroyFontFamily,
                            )
                        }
                        1 -> {
                            Text(
                                text = "We help people connect with store\naround Bangladesh",
                                color = androidx.compose.ui.graphics.Color.Cyan,
                                fontSize = 18.sp,
                                textAlign = TextAlign.Center
                            )
                        }
                        else -> {
                            Text(
                                text = "We show easy way to shop.\nJust stay at home with us",
                                color = androidx.compose.ui.graphics.Color.Cyan,
                                fontSize = 18.sp,
                                textAlign = TextAlign.Center
                            )

                        }
                    }
                    Spacer(modifier = Modifier.height(30.dp))

                    Image(
                        painter = painterResource(id = splashImageList[currentPosition.value]),
                        contentDescription = "Splash Image",
                        modifier = Modifier.padding(40.dp)
                    )
                }
            }
        )


        DotIndicator(splashImageList.size, currentPosition.value)

        Button(
            onClick = {

            },
            modifier = Modifier
                .fillMaxWidth()
                .height(height = DIMENS_68dp)
                .padding(start = DIMENS_16dp, end = DIMENS_16dp),
            colors = ButtonDefaults.buttonColors(backgroundColor = Green),
            shape = RoundedCornerShape(DIMENS_12dp),
        ) {
            androidx.compose.material3.Text(
                text = "hello",
                fontFamily = GilroyFontFamily,
                fontWeight = FontWeight.SemiBold,
                fontSize = TEXT_SIZE_18sp,
                color = androidx.compose.ui.graphics.Color.White
            )
        }
    }
}