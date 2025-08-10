import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import di.KoinInitializer

fun main() = application {
    KoinInitializer().init()
    Window(
        onCloseRequest = ::exitApplication,
        alwaysOnTop = true
    ) {
        App()
    }
}