package org.inc.dw2mongodbimporterexportertool.mod

import org.springframework.data.annotation.Id

class Mod(
        @Id
        val id: String,
        val name: String
)