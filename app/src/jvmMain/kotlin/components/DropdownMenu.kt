package components

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.material.DropdownMenu
import androidx.compose.material.DropdownMenuItem
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import model.toModImport

class DropdownMenu private constructor(){
    @Composable
    @Preview
    fun render() {
        DropdownMenu(
            TopAppBar.singleton.isTopBarExpanded.value,
            onDismissRequest = { TopAppBar.singleton.minimize() }) {
            DropdownMenuItem(
                onClick = {
                    TopAppBar.singleton.minimize()
                    Body.singleton.onLoadFromFiles()
                }
            ) {
                Text("import from files")
            }
            DropdownMenuItem(
                onClick = {
                    TopAppBar.singleton.minimize()
                },
                enabled = false
            ) {
                Text("TODO: import from database")
            }
        }
    }

    companion object {
        val singleton = DropdownMenu()
    }
}


