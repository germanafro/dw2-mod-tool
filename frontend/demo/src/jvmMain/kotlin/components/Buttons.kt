package components

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*

@Composable
@Preview
fun helloButton() {
    var mutableText by remember { mutableStateOf("Hello, World!") }
    Button(onClick = {
        mutableText = "Hello, Desktop!"
    }) {
        Text(mutableText)
    }
}