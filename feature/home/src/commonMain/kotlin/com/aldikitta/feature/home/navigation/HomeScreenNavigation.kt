package com.aldikitta.feature.home.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.aldikitta.feature.home.HomeScreen

const val HOME_SCREEN = "home_screen_routes"
fun NavController.navigateHomeScreen(navOptions: NavOptions? = null) {
    this.navigate(HOME_SCREEN, navOptions)
}

fun NavGraphBuilder.homeScreen(
    navigateToB: () -> Unit
) {
    composable(
        route = HOME_SCREEN,
        content = {
            HomeScreen(navigateToB)
        },
    )
}