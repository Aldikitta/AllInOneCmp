package com.aldikitta.feature.home.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.aldikitta.base.routes.Routes.MOVIE_HOME_SCREEN
import com.aldikitta.feature.home.HomeScreen

fun NavController.navigateHomeScreen(navOptions: NavOptions? = null) {
    this.navigate(MOVIE_HOME_SCREEN, navOptions)
}

fun NavGraphBuilder.homeScreen(
    navigateToB: () -> Unit,
    dummyText: String,
) {
    composable(
        route = MOVIE_HOME_SCREEN,
        content = {
            HomeScreen(navigateToB, dummyText)
        },
    )
}