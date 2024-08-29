package com.aldikitta.feature.movie.movie_home.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.aldikitta.base.navigation.MovieHomeScreen
import com.aldikitta.feature.movie.movie_home.MovieHomeScreen

fun NavController.navigateMovieHomeScreen(navOptions: NavOptions? = null) {
    this.navigate(MovieHomeScreen, navOptions)
}

fun NavGraphBuilder.movieHomeScreen(
    navigateToB: () -> Unit,
) {
    composable<MovieHomeScreen> {
        MovieHomeScreen(navigateToB)
    }
}