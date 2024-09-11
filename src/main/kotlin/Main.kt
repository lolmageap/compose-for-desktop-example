import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.WindowPlacement
import androidx.compose.ui.window.WindowState
import androidx.compose.ui.window.application
import domain.view.Screen.*
import domain.view.homeScreen
import domain.view.loginScreen
import domain.view.signUpScreen

fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = "Baum Blog",
        state = WindowState(
            width = 1280.dp,
            height = 840.dp,
            placement = WindowPlacement.Floating,
        ),
    ) {
        var currentScreen by remember { mutableStateOf(LOGIN) }

        when (currentScreen) {
            LOGIN -> loginScreen(
                onLoginSuccess = { currentScreen = HOME },
                moveToSignUp = { currentScreen = SIGN_UP },
            )
            SIGN_UP -> signUpScreen(
                onSignUpSuccess = { currentScreen = HOME },
            )
            HOME -> homeScreen()
        }
    }
}