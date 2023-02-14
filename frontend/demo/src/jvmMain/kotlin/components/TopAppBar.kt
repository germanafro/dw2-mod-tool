package components

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import openInBrowser
import java.net.URI

class TopAppBar private constructor(){
    val isTopBarExpanded = mutableStateOf(false)
    @Composable
    @Preview
    fun render() =
        TopAppBar(
            title = { Text("DW2 - Mod import tool") },
            navigationIcon = {
                IconButton(onClick = { this.expand() }) {
                    Icon(Icons.Filled.Menu, contentDescription = null)
                }
                DropdownMenu.singleton.render()
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

    fun expand(){
        isTopBarExpanded.value = true
    }
    fun minimize(){
        isTopBarExpanded.value = false
    }
    companion object{
        val singleton = TopAppBar()
    }
}