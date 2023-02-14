package components

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.material.BottomAppBar
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable

class BottomAppBar private constructor(){
    @Composable
    @Preview
    fun render() {
        BottomAppBar() {
            if (Body.singleton.content.value is BodyContentSelectFiles) {
                Button(onClick = {}) {
                    Text("Import")
                }
                Button(onClick = {}) {
                    Text("Export")
                }
            }
        }
    }

    companion object{
        val singleton = BottomAppBar()
    }
}