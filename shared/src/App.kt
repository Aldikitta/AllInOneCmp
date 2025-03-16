import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import navigation.graph.dashboardGraph
import org.koin.compose.KoinContext

@Composable
fun App() {
    MaterialTheme {
        KoinContext {
            val navController: NavHostController = rememberNavController()
            NavHost(
                navController = navController,
                startDestination = DashboardNavGraph,
            ) {
                dashboardGraph(
                    navigateToMovie = {
//                        navController.navigateToMovieNavGraph()
                    },
                    navigateToEcommerce = {

                    },
                    navigateToCmpPlayground = {

                    }
                )
//                movieNavGraph(navController)
            }
        }
    }
}