package com.aldikitta.feature.dashboard.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.aldikitta.base.navigation.DashboardScreen
import com.aldikitta.feature.dashboard.DashboardScreen

fun NavGraphBuilder.dashboardScreen(
    navigateToMovie: () -> Unit,
    navigateToEcommerce: () -> Unit,
    navigateToCmpPlayground: () -> Unit
) {
    composable<DashboardScreen> {
        DashboardScreen(
            navigateToMovie = navigateToMovie,
            navigateToEcommerce = navigateToEcommerce,
            navigateToCmpPlayground = navigateToCmpPlayground,
            navigateToDynamicForm = {},
            navigateToDsl = {}
        )
    }
}