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
    //ReadCatalog
    override fun getListCatalog(): List<Catalog> =
        catalogRepository.getListCatalog()
    //Update Catalog
    //delete catalog by id
    //show catalog by type
    //search catalog

}