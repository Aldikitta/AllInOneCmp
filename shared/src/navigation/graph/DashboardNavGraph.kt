package navigation.graph

import DashboardNavGraph
import DashboardScreen
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.navigation
import navigation.dashboardScreen

fun NavController.navigateToDashboardNavGraph(navOptions: NavOptions? = null) {
    this.navigate(DashboardNavGraph, navOptions)
}

fun NavGraphBuilder.dashboardGraph(
    navigateToMovie: () -> Unit,
    navigateToEcommerce: () -> Unit,
    navigateToCmpPlayground: () -> Unit
) {
    navigation<DashboardNavGraph>(
        startDestination = DashboardScreen
    ) {
        dashboardScreen(
            navigateToMovie = navigateToMovie,
            navigateToEcommerce = navigateToEcommerce,
            navigateToCmpPlayground = navigateToCmpPlayground
        )
    }
}