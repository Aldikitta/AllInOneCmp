package navigation

import DashboardNavGraph
import DashboardScreen
import androidx.navigation.NavGraphBuilder
import androidx.navigation.navigation

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