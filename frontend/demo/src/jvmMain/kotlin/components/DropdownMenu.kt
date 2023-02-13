package components

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.material.DropdownMenu
import androidx.compose.material.DropdownMenuItem
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.application
import components.Body.Companion.bodyState
import components.Root.Companion.isTopBarExpanded

@Composable
@Preview
fun dropdownMenu() {
    DropdownMenu(isTopBarExpanded.value, onDismissRequest = {isTopBarExpanded.value = false}){
        DropdownMenuItem(
            onClick = {
                isTopBarExpanded.value = false
                bodyState.value = BodyState.SELECT_FOLDER
            }
        ){
            Text("select folder")
        }
    }
}


