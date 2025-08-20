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
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.key
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import kotlinx.coroutines.launch
import org.jetbrains.compose.resources.getString
import org.jetbrains.compose.resources.stringResource
import org.koin.compose.koinInject
import resources.generated.resources.Res
import resources.generated.resources.internet_connected
import resources.generated.resources.internet_not_connected
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

    var customAppLocale by mutableStateOf<String?>(null)

    LaunchedEffect(connectionStatus) {
        if (connectionStatus == ConnectionStatus.Available) {
            scope.launch {
                snackBarHostState.showSnackbar(message = getString(Res.string.internet_connected), duration = SnackbarDuration.Indefinite)
            }
        } else {
            scope.launch {
                snackBarHostState.showSnackbar(message = getString(Res.string.internet_not_connected), duration = SnackbarDuration.Indefinite)
            }
        }
    }
    CompositionLocalProvider(
        LocalAppLocale provides customAppLocale,
    ) {
        key(customAppLocale) {
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
    }
}