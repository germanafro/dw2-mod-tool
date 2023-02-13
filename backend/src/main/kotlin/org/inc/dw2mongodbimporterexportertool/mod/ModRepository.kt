package org.inc.dw2mongodbimporterexportertool.mod

import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface ModRepository: CrudRepository<Mod, String>{
    override fun findAll(): List<Mod>
}