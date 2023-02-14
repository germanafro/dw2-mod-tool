package components

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable


class Scaffold private constructor() {

    private val bottomAppBar: BottomAppBar = BottomAppBar.singleton
    private val topAppBar: TopAppBar = TopAppBar.singleton
    @Composable
    @Preview
    fun render() {
        Scaffold(
            topBar = { topAppBar.render() },
            bottomBar = { bottomAppBar.render() }
        ) {
            Body.singleton.render()
        }
    }

    companion object{
        val singleton = Scaffold()
    }
}

