package com.viona.researchcatalog.catalog.repository

import com.mongodb.client.MongoCollection
import com.viona.researchcatalog.catalog.entity.Catalog
import com.viona.researchcatalog.database.DatabaseComponent
import org.litote.kmongo.*
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

    override fun deleteCatalog(id: Int) {
        catalogCollection().findOneAndDelete(Catalog::id eq id)
    }

    override fun getCatalogById(id: Int): Catalog? =
        catalogCollection().findOne(Catalog::id eq id)

    override fun updateCatalog(id: Int, catalog: Catalog): Catalog? {

        val update = catalogCollection().updateOne(
            catalog::id eq id,
            Catalog(
                id = catalog.id,
                title = catalog.title,
                category = catalog.category,
                url = catalog.url,
                iconUrl = catalog.iconUrl,
                imageUrl = catalog.imageUrl,
                description = catalog.description
            )
        )

        return if (update.wasAcknowledged()) getCatalogById(id)
        else throw java.lang.IllegalStateException("update gagal")
    }
}