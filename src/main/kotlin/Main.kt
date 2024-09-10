import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import androidx.compose.ui.window.rememberWindowState
import domain.view.loginScreen

fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = "Login",
        state = rememberWindowState(width = 400.dp, height = 300.dp)
    ) {
        loginScreen()
    }
}