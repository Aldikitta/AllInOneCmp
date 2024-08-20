import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.aldikitta.base.routes.Routes.DASHBOARD
import com.aldikitta.base.routes.Routes.INITIAL
import com.aldikitta.base.routes.Routes.MOVIE_HOME_SCREEN
import com.aldikitta.feature.dashboard.navigation.dashboardScreen
import com.aldikitta.feature.detail.navigation.detailScreen
import com.aldikitta.feature.detail.navigation.navigateDetailScreen
import com.aldikitta.feature.home.navigation.homeScreen
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource
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
                route = INITIAL,
                startDestination = DASHBOARD,
            ) {
                dashboardScreen()
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