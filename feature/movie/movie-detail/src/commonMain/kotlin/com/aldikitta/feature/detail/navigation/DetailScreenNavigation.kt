package com.aldikitta.feature.detail.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.aldikitta.base.routes.Routes.MOVIE_DETAIL_SCREEN
import com.aldikitta.feature.detail.DetailScreen

fun NavController.navigateDetailScreen(navOptions: NavOptions? = null) {
    this.navigate(MOVIE_DETAIL_SCREEN, navOptions)
}

fun NavGraphBuilder.detailScreen(
    dummyText: String
) {
    composable(
        route = MOVIE_DETAIL_SCREEN,
        content = {
            DetailScreen(dummyText)
        },
    )
}