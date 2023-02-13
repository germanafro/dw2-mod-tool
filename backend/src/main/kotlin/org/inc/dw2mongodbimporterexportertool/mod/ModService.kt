package org.inc.dw2mongodbimporterexportertool.mod

import org.springframework.stereotype.Service
import java.util.*

@Service
class ModService(
        val repository: ModRepository
) {
    init {
        repository.deleteAll()
        repository.saveAll(fooList)
    }
    fun getAll(): List<Mod> = repository.findAll()

    companion object {
        val fooList: List<Mod> = listOf(
                Mod(UUID.fromString("0-0-0-0-1").toString(),"hello"),
                Mod(UUID.fromString("0-0-0-0-2").toString(),"world")
        )
    }
}