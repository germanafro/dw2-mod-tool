package model

import com.fasterxml.jackson.module.kotlin.readValue
import model.Serde.Companion.mapper
import java.io.File

data class ModImport(
    val description: ModDescription,
    val fileImports: List<FileImport>
)

data class ModDescription(
    val displayName: String,
    val shortDescription: String,
    val version: String,
    val bundles: List<String>
){
    companion object{
        fun empty() = ModDescription("please import a mod.", "", "", listOf())
    }
}


 fun List<File>.toModImport(): ModImport = this.map { file -> FileImport(true, file, file.name)  }.let { imports ->
     ModImport(mapper.readValue(imports.first{ it.name == "mod.json"}.file), imports)
 }



