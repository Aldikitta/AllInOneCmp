package com.aldikitta.feature.detail.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.aldikitta.feature.detail.DetailScreen

const val DETAIL_SCREEN = "detail_screen_routes"
fun NavController.navigateDetailScreen(navOptions: NavOptions? = null) {
    this.navigate(DETAIL_SCREEN, navOptions)
}

fun NavGraphBuilder.detailScreen() {
    composable(
        route = DETAIL_SCREEN,
        content = {
            DetailScreen()
        },
    )
}