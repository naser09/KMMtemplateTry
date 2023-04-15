import androidx.compose.ui.window.ComposeUIViewController

actual fun getPlatformName(): String = "iOS"

fun MainViewController() = ComposeUIViewController { App() }
//fun MainViewController() = PreComposeApplication("MyPreComposeApp"){ App() }