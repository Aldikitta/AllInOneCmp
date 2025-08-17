import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import navigation.dashboardGraph
import org.koin.compose.KoinContext
import org.koin.compose.viewmodel.koinViewModel
import screen.CmpIsFunScreenViewModel

@Composable
fun App() {
    MaterialTheme {
        val navController: NavHostController = rememberNavController()
        val viewModel = koinViewModel<CmpIsFunScreenViewModel>()
        NavHost(
            navController = navController,
            startDestination = DashboardNavGraph
        ) {
            dashboardGraph(
                screenViewModel = viewModel,
                navigateToMovie = {
//                        navController.navigateToMovieNavGraph()
                },
                navigateToEcommerce = {

                },
                navigateToCmpPlayground = {
                }
            )
        }
    }
}