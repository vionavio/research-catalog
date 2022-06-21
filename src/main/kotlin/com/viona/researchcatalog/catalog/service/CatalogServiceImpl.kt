package com.viona.researchcatalog.catalog.service

import com.viona.researchcatalog.catalog.entity.Catalog
import com.viona.researchcatalog.catalog.repository.CatalogRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class CatalogServiceImpl : CatalogService {

    @Autowired
    private lateinit var catalogRepository: CatalogRepository


    //CRUD
    //Create Catalog
    override fun addCatalog(catalog: Catalog): List<Catalog> =
        catalogRepository.addCatalog(catalog)
    //ReadCatalog
    override fun getListCatalog(): List<Catalog> =
        catalogRepository.getListCatalog()

    //Update Catalog
    //delete catalog by id
    override fun deleteCatalog(id: Int): Catalog? =
        catalogRepository.deleteCatalog(id)
    //show catalog by type
    //search catalog

}