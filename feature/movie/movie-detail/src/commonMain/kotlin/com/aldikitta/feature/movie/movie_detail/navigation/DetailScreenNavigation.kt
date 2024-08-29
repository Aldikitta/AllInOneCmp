package com.aldikitta.feature.movie.movie_detail.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.aldikitta.base.navigation.Routes.MOVIE_DETAIL_SCREEN
import com.aldikitta.feature.movie.movie_detail.DetailScreen

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