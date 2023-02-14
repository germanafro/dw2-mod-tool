import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import components.Root

fun main() = application {
    Window(title = "dw2-mod-import-export", onCloseRequest = ::exitApplication) {
        Root.singleton.render()
    }
}

