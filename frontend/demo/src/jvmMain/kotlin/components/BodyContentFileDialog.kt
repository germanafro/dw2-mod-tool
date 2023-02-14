package components

import androidx.compose.runtime.Composable
import androidx.compose.ui.window.AwtWindow
import model.toModImport
import java.awt.FileDialog
import java.awt.Frame
import java.io.File

class BodyContentFileDialog private constructor(): IBodyContent {
    override fun renderer(): @Composable () -> Unit {
        return {
            FileDialog(
                onCloseRequest = {
                    Body.singleton.onFilesLoaded(it.toModImport())
                }
            )
        }
    }

    @Composable
    fun FileDialog(
        parent: Frame? = null,
        onCloseRequest: (result: List<File>) -> Unit
    ) = AwtWindow(
        create = {
            object : FileDialog(parent, "Choose files", LOAD) {
                override fun setVisible(value: Boolean) {
                    super.setVisible(value)
                    if (value) {
                        onCloseRequest(files.asList())
                    }
                }
            }.also { it.isMultipleMode = true }
        },
        dispose = FileDialog::dispose
    )

    companion object{
        val singleton = BodyContentFileDialog()
    }
}