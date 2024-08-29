import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.aldikitta.base.navigation.DashboardNavGraph
import navigation.graph.dashboardGraph
import navigation.graph.movieNavGraph
import navigation.graph.navigateToMovieNavGraph
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.KoinContext
import org.koin.compose.currentKoinScope


@Composable
@Preview
fun App() {
    MaterialTheme {
        KoinContext {
            val navController: NavHostController = rememberNavController()
            val viewModel = koinViewModel<MainViewModel>()
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
//                dashboardGraph()
//                homeScreen(
//                    navigateToB = {
//                        navController.navigateDetailScreen()
//                    },
//                    dummyText = viewModel.getDummyText()
//                )
//
//                detailScreen(dummyText = viewModel.getDummyText())
            }
        }
    }
}

@Composable
inline fun <reified T: ViewModel> koinViewModel(): T {
    val scope = currentKoinScope()
    return viewModel {
        scope.get<T>()
    }
}