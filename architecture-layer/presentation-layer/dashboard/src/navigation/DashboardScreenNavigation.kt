package navigation

import DashboardScreen
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable

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