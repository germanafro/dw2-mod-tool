package components

import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import model.ModDescription
import model.ModImport

class Body private constructor(){
    val content: MutableState<IBodyContent>  =  mutableStateOf( BodyContentInit.singleton)
    val import = mutableStateOf(ModImport(ModDescription.empty(), listOf()))


    @Composable
    fun render(){
        content.value.renderer().invoke()
    }

    fun onLoadFromFiles(){
        this.content.value = BodyContentFileDialog.singleton
    }
    fun onFilesLoaded(import: ModImport){
        this.content.value = BodyContentSelectFiles.singleton
        this.import.value = import
    }

    companion object{
        val singleton = Body()
    }
}

