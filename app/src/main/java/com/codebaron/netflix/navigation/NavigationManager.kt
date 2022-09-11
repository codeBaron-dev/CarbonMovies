package com.codebaron.netflix.navigation

import AccountOption
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.codebaron.netflix.MainActivity
import com.codebaron.netflix.screens.FilmDetailsRequestHandler
import com.codebaron.netflix.screens.MovieRequestHandler
import com.codebaron.netflix.screens.SplashScreen

@Composable
fun ScreensNavigationManager(
    mainActivity: MainActivity,
    networkState: Boolean
) {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Destinations.SPLASH_SCREEN.name
    ) {
        composable(Destinations.SPLASH_SCREEN.name) {
            SplashScreen(networkState, navController)
        }
        composable(Destinations.ACCOUNT_OPTION_SCREEN.name) {
            AccountOption(mainActivity, networkState, navController)
        }
        composable(Destinations.HOME_SCREEN.name) {
            MovieRequestHandler(mainActivity, networkState, navController)
        }
        composable("${Destinations.MOVIE_DETAILS_SCREEN.name}/{movie_id}",
            arguments = listOf(navArgument("movie_id") {
                defaultValue = "1"
            })
        ) { stackEntry ->
            stackEntry.arguments?.getString("movie_id")?.let { FilmDetailsRequestHandler(it, networkState) }
        }
    }
}