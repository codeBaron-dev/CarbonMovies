package com.codebaron.netflix.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.codebaron.netflix.R
import com.codebaron.netflix.navigation.Destinations
import com.codebaron.netflix.ui.theme.NetflixTheme
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(
    networkState: Boolean,
    navController: NavHostController
) {
    val localContext = LocalContext.current

    Scaffold {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(color = Color.Black),
            contentAlignment = Alignment.Center
        ) {
            Image(
                modifier = Modifier
                    .height(200.dp)
                    .width(300.dp),
                painter = painterResource(id = R.drawable.net),
                contentDescription = null,
                contentScale = ContentScale.FillWidth
            )
        }
        LaunchedEffect(Unit) {
            delay(3000)
            navController.navigate(Destinations.ACCOUNT_OPTION_SCREEN.name)
        }
    }
}

@Composable
@Preview
fun SplashScreenUI() {
    NetflixTheme {
        SplashScreen(true, rememberNavController())
    }
}