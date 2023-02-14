package components

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material.Checkbox
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.ExperimentalUnitApi
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import model.FileImport

@OptIn(ExperimentalUnitApi::class)

class BodyContentSelectFiles private constructor(): IBodyContent {
    override fun renderer(): @Composable () -> Unit {
        return {
            Column {
                Text(
                    text = Body.singleton.import.value.description.displayName,
                    fontSize = TextUnit(2F, TextUnitType.Em)
                )
                Text(
                    text = Body.singleton.import.value.description.shortDescription,
                    fontSize = TextUnit(1F, TextUnitType.Em)
                )
                Body.singleton.import.value.fileImports.forEach {
                    selectableElement(it)
                }
            }
        }
    }

    @Composable
    @Preview
    fun selectableElement(import: FileImport){
        Row(verticalAlignment = Alignment.CenterVertically) {
            Checkbox(import.selected, onCheckedChange = { value -> import.selected = value })
            Text(import.name)
        }
    }
    companion object{
        val singleton = BodyContentSelectFiles()
    }
}