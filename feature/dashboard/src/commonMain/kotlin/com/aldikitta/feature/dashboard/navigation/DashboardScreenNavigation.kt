package com.aldikitta.feature.dashboard.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.aldikitta.base.routes.Routes.DASHBOARD
import com.aldikitta.feature.dashboard.DashboardScreen


fun NavController.navigateDashboardScreen(navOptions: NavOptions? = null) {
    this.navigate(DASHBOARD, navOptions)
}

fun NavGraphBuilder.dashboardScreen() {
    composable(
        route = DASHBOARD,
        content = {
            DashboardScreen()
        },
    )
}