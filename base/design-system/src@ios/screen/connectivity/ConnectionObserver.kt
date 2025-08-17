package screen.connectivity

// iosMain
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import platform.Network.*
import platform.darwin.*

actual class ConnectivityObserver {
    actual val connectionStatus: Flow<ConnectionStatus> = callbackFlow {
        val monitor = nw_path_monitor_create()
        nw_path_monitor_set_queue(monitor, dispatch_get_main_queue())

        nw_path_monitor_set_update_handler(monitor) { path ->
            if (nw_path_get_status(path) == nw_path_status_satisfied) {
                trySend(ConnectionStatus.Available)
            } else {
                trySend(ConnectionStatus.Unavailable)
            }
        }

        nw_path_monitor_start(monitor)
        awaitClose { nw_path_monitor_cancel(monitor) }
    }
}
