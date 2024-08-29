import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.aldikitta.base.navigation.DashboardNavGraph
import navigation.graph.dashboardGraph
import navigation.graph.movieNavGraph
import navigation.graph.navigateToMovieNavGraph
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.KoinContext

@Composable
@Preview
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
                        navController.navigateToMovieNavGraph()
                    },
                    navigateToEcommerce = {

                    },
                    navigateToCmpPlayground = {

                    }
                )
                movieNavGraph(navController)
            }
        }
    }
}