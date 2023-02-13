package components

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material.Checkbox
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.window.AwtWindow
import components.Body.Companion.bodyState
import components.Body.Companion.files
import java.awt.FileDialog
import java.awt.Frame

@Composable
@Preview
fun bodyContent() {
    when(bodyState.value) {
        BodyState.INIT -> bodyInit()
        BodyState.SELECT_FOLDER -> bodySelectFolder()
        BodyState.SHOW_MODS -> bodySelectMods()
    }

}

@Composable
@Preview
fun bodyInit() {
    Text("Hello World")
}

@Composable
@Preview
fun bodySelectFolder() {
    FileDialog(
        onCloseRequest = {
            bodyState.value = BodyState.SHOW_MODS
            files.value = it
        }
    )
}

@Composable
private fun FileDialog(
    parent: Frame? = null,
    onCloseRequest: (result: List<String>) -> Unit
) = AwtWindow(
    create = {
        object : FileDialog(parent, "Choose files", LOAD) {
            override fun setVisible(value: Boolean) {
                super.setVisible(value)
                if (value) {
                    when(isMultipleMode){
                        true -> onCloseRequest(files.map { file -> file.name })
                        false -> onCloseRequest(listOf(file))
                    }
                }
            }
        }.also { it.isMultipleMode = true }
    },
    dispose = FileDialog::dispose
)

@Composable
@Preview
fun bodySelectMods() {
    Column {
        files.value.forEach{
            selectableElement(it)
        }
    }
}

@Composable
@Preview
fun selectableElement(text: String){
    var checked by remember { mutableStateOf(false) }
    Row(verticalAlignment = Alignment.CenterVertically) {
        Checkbox(checked, onCheckedChange = {value -> checked = value})
        Text(text)
    }
}


class Body{
    companion object{
        var bodyState = mutableStateOf(BodyState.INIT)
        var files = mutableStateOf(listOf<String>())
    }
}

enum class BodyState(
    val value: String
){
    INIT("Init"),
    SELECT_FOLDER("Select folder"),
    SHOW_MODS("Show mods")
}