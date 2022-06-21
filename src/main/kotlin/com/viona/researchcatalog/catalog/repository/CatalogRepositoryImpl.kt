package com.viona.researchcatalog.catalog.repository

import com.mongodb.client.MongoCollection
import com.viona.researchcatalog.catalog.entity.Catalog
import com.viona.researchcatalog.database.DatabaseComponent
import org.litote.kmongo.eq
import org.litote.kmongo.getCollection
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Repository

@Repository
class CatalogRepositoryImpl : CatalogRepository {


    @Autowired
    private lateinit var databaseComponent: DatabaseComponent

    private fun catalogCollection(): MongoCollection<Catalog> =
        databaseComponent.database.getDatabase("catalog").getCollection()

    override fun getListCatalog(): List<Catalog> =
        catalogCollection().find().toList()

    override fun addCatalog(catalog: Catalog): List<Catalog> {
        val insert = catalogCollection().insertOne(catalog)

        return if (insert.wasAcknowledged()) getListCatalog()
        else throw java.lang.IllegalStateException("insert gagal")
    }

    override fun deleteCatalog(id: Int): Catalog? =
        catalogCollection().findOneAndDelete(Catalog::id eq id)


}