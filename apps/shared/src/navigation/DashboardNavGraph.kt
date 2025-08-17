package navigation

import DashboardNavGraph
import DashboardScreen
import androidx.navigation.NavGraphBuilder
import androidx.navigation.navigation
import screen.CmpIsFunScreenViewModel

fun NavGraphBuilder.dashboardGraph(
    screenViewModel: CmpIsFunScreenViewModel,
    navigateToMovie: () -> Unit,
    navigateToEcommerce: () -> Unit,
    navigateToCmpPlayground: () -> Unit
) {
    navigation<DashboardNavGraph>(
        startDestination = DashboardScreen
    ) {
        dashboardScreen(
            screenViewModel = screenViewModel,
            navigateToMovie = navigateToMovie,
            navigateToEcommerce = navigateToEcommerce,
            navigateToCmpPlayground = navigateToCmpPlayground
        )
    }
}