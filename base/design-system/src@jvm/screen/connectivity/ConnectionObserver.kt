package screen.connectivity

import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import java.net.InetSocketAddress
import java.net.Socket
import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit

actual class ConnectivityObserver {
    actual val connectionStatus: Flow<ConnectionStatus> = callbackFlow {
        val executor = Executors.newSingleThreadScheduledExecutor()

        val check = Runnable {
            val available = isInternetAvailable()
            trySend(if (available) ConnectionStatus.Available else ConnectionStatus.Unavailable)
        }

        // run immediately and then every 5 seconds
        executor.scheduleAtFixedRate(check, 0, 5, TimeUnit.SECONDS)

        awaitClose { executor.shutdownNow() }
    }

    private fun isInternetAvailable(): Boolean {
        return try {
            Socket().use { socket ->
                socket.connect(InetSocketAddress("8.8.8.8", 53), 1500) // Google DNS
                true
            }
        } catch (e: Exception) {
            false
        }
    }
}
