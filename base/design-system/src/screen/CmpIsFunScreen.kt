package screen

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import kotlinx.coroutines.launch
import org.koin.compose.koinInject
import screen.connectivity.ConnectionStatus
import screen.connectivity.ConnectivityObserver

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CmpIsFunScreen(
    titleTopBar: String? = "",
    content: @Composable ((PaddingValues) -> Unit) = {}
) {
    val connectivityObserver: ConnectivityObserver = koinInject()
    val connectionStatus by connectivityObserver.connectionStatus.collectAsState(initial = ConnectionStatus.Available)

    val snackBarHostState = remember { SnackbarHostState() }
    val scope = rememberCoroutineScope()

    LaunchedEffect(connectionStatus) {
        if (connectionStatus == ConnectionStatus.Available) {
            scope.launch {
                snackBarHostState.showSnackbar(message = "Connected", duration = SnackbarDuration.Short)
            }
        } else {
            scope.launch {
                snackBarHostState.showSnackbar(message = "Disconnected", duration = SnackbarDuration.Short)
            }
        }
    }

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(text = titleTopBar.orEmpty())
                }
            )
        },
        snackbarHost = {
            SnackbarHost(snackBarHostState)
        },
        content = content
    )
}