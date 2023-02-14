package components

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf

class Root private constructor(){

    private val scaffold: Scaffold = Scaffold.singleton


    @Composable
    @Preview
    fun render() {
        MaterialTheme {
            scaffold.render()
        }
    }

    companion object{
        val singleton = Root()
    }

}