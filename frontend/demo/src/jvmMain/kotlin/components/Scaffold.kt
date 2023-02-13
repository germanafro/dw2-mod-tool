package components

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.*
import components.Body.Companion.bodyState
import components.Root.Companion.isTopBarExpanded
import openInBrowser
import java.net.URI

@Composable
@Preview
fun root() {
    MaterialTheme {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = { Text("DW2 - Mod import tool") },
                    navigationIcon = {
                        IconButton(onClick = { isTopBarExpanded.value = true }) {
                            Icon(Icons.Filled.Menu, contentDescription = null)
                        }
                        dropdownMenu()
                    },
                    actions = {
                        // RowScope here, so these icons will be placed horizontally
                        IconButton(onClick = { /* doSomething() */
                            openInBrowser(URI("https://github.com/germanafro/dw2-mod-tool"))
                        }) {
                            Icon(Icons.Filled.Info, contentDescription = "Website Link")
                        }
                    }
                )
            },
            bottomBar = {
                if(bodyState.value == BodyState.SHOW_MODS) {
                    BottomAppBar() {
                        Button(onClick = {}) {
                            Text("Import")
                        }
                        Button(onClick = {}) {
                            Text("Export")
                        }
                    }
                }
            }
        ) {
            // Screen content
            bodyContent()
        }
    }
}

class Root{
    companion object{
        var isTopBarExpanded = mutableStateOf(false)
    }
}