package navigation.graph

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.navigation
import com.aldikitta.base.navigation.DashboardNavGraph
import com.aldikitta.base.navigation.DashboardScreen
import com.aldikitta.feature.dashboard.navigation.dashboardScreen

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