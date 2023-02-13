import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import components.root

fun main() = application {
    Window(title = "dw2-mod-import-export", onCloseRequest = ::exitApplication) {
        root()
    }
}

