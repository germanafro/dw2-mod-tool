package components

import androidx.compose.material.Text
import androidx.compose.runtime.Composable

class BodyContentInit private constructor(): IBodyContent {
    override fun renderer(): @Composable () -> Unit {
        return {
            Text("Hello World")
        }
    }
    companion object{
        val singleton = BodyContentInit()
    }
}

