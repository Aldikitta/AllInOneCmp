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
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.aldikitta.feature.detail.navigation.detailScreen
import com.aldikitta.feature.detail.navigation.navigateDetailScreen
import com.aldikitta.feature.home.navigation.HOME_SCREEN
import com.aldikitta.feature.home.navigation.homeScreen
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview

import moviekmp.composeapp.generated.resources.Res
import moviekmp.composeapp.generated.resources.compose_multiplatform

const val initial = "initial"

@OptIn(ExperimentalResourceApi::class)
@Composable
@Preview
fun App() {
    MaterialTheme {
        val navController: NavHostController = rememberNavController()

        NavHost(
            navController = navController,
            route = initial,
            startDestination = HOME_SCREEN,
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
        ) {
            homeScreen {
                navController.navigateDetailScreen()
            }

            detailScreen()
        }
    }
}