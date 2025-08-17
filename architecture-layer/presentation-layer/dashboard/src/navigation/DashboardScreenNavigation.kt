package navigation

import DashboardScreen
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import screen.CmpIsFunScreenViewModel

fun NavGraphBuilder.dashboardScreen(
    screenViewModel: CmpIsFunScreenViewModel,
    navigateToMovie: () -> Unit,
    navigateToEcommerce: () -> Unit,
    navigateToCmpPlayground: () -> Unit
) {
    composable<DashboardScreen> {
        DashboardScreen(
            screenViewModel = screenViewModel,
            navigateToMovie = navigateToMovie,
            navigateToEcommerce = navigateToEcommerce,
            navigateToCmpPlayground = navigateToCmpPlayground,
            navigateToDynamicForm = {},
            navigateToDsl = {}
        )
    }
}