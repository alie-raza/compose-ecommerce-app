package com.alidev.ecommerceapplication.presentation

import android.annotation.SuppressLint
import android.window.SplashScreen
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.alidev.ecommerceapplication.R
import com.alidev.ecommerceapplication.presentation.component.DotIndicator
import com.alidev.ecommerceapplication.ui.theme.DIMENS_12dp
import com.alidev.ecommerceapplication.ui.theme.DIMENS_16dp
import com.alidev.ecommerceapplication.ui.theme.DIMENS_40dp
import com.alidev.ecommerceapplication.ui.theme.GilroyFontFamily
import com.alidev.ecommerceapplication.ui.theme.Orange
import com.alidev.ecommerceapplication.ui.theme.TEXT_SIZE_18sp
import com.alidev.ecommerceapplication.ui.theme.TextColor
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun SplashScreen(
    navController: NavHostController,
) {
    val splashImageList = listOf(
        R.drawable.splash_1,
        R.drawable.splash_2,
        R.drawable.splash_3,
    )

    val pagerState = rememberPagerState(initialPage = 0)
    val coroutineScope = rememberCoroutineScope() // ✅ Use this scope

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(30.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceAround
    ) {
        HorizontalPager(
            count = splashImageList.size,
            state = pagerState,
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
        ) { page ->

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .padding(top = 10.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Text(
                    text = "JEXMON",
                    fontSize = 50.sp,
                    color = Orange,
                    fontWeight = FontWeight.Bold,
                    fontFamily = GilroyFontFamily,
                )

                Spacer(modifier = Modifier.height(5.dp))

                when (page) {
                    0 -> {
                        Text(
                            text = buildAnnotatedString {
                                append("Welcome to ")
                                withStyle(
                                    style = SpanStyle(
                                        fontWeight = FontWeight.Bold,
                                        color = TextColor,
                                    )
                                ) {
                                    append("Jexmon.")
                                }
                                append(" Let's Shop!")
                            },
                            color = TextColor,
                            fontSize = 18.sp,
                            textAlign = TextAlign.Center,
                            fontFamily = GilroyFontFamily,
                        )
                    }
                    1 -> {
                        Text(
                            text = "We help people connect with store\naround Bangladesh",
                            color = TextColor,
                            fontSize = 18.sp,
                            textAlign = TextAlign.Center
                        )
                    }
                    else -> {
                        Text(
                            text = "We show easy way to shop.\nJust stay at home with us",
                            color = TextColor,
                            fontSize = 18.sp,
                            textAlign = TextAlign.Center
                        )
                    }
                }

                Spacer(modifier = Modifier.height(30.dp))

                Image(
                    painter = painterResource(id = splashImageList[page]),
                    contentDescription = "Splash Image",
                    modifier = Modifier.padding(40.dp)
                )
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        DotIndicator(splashImageList.size, pagerState.currentPage)

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                if (pagerState.currentPage < splashImageList.lastIndex) {
                    coroutineScope.launch {
                        pagerState.animateScrollToPage(pagerState.currentPage + 1) // ✅ safe call
                    }
                } else {
                    // navigate to home
//                    navController.navigate("home") {
//                        popUpTo("onboarding") { inclusive = true }
//                    }
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(DIMENS_40dp)
                .padding(horizontal = DIMENS_16dp),
            colors = ButtonDefaults.buttonColors(backgroundColor = Orange),
            shape = RoundedCornerShape(DIMENS_12dp),
        ) {
            Text(
                text = if (pagerState.currentPage == splashImageList.lastIndex) "Get Started" else "Next",
                fontFamily = GilroyFontFamily,
                fontWeight = FontWeight.SemiBold,
                fontSize = TEXT_SIZE_18sp,
                color = Color.White
            )
        }

    }
}


