package model

import java.io.File

data class FileImport(
    var selected: Boolean,
    val file: File,
    val name: String
)

