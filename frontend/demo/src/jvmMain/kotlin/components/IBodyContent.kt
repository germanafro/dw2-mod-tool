package components

import androidx.compose.runtime.Composable

interface IBodyContent{
    fun renderer(): @Composable () -> Unit
}