package com.viona.researchcatalog.catalog.service

import com.viona.researchcatalog.catalog.entity.Catalog
import com.viona.researchcatalog.catalog.repository.CatalogRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class CatalogServiceImpl : CatalogService {

    @Autowired
    private lateinit var catalogRepository: CatalogRepository

    override fun addCatalog(catalog: Catalog): List<Catalog> =
        catalogRepository.addCatalog(catalog)

    override fun getListCatalog(): List<Catalog> =
        catalogRepository.getListCatalog()

    override fun deleteCatalog(id: Int): Catalog? =
        catalogRepository.deleteCatalog(id)

    override fun getCatalogById(id: Int): Catalog? =
        catalogRepository.getCatalogById(id)

    override fun updateCatalog(id: Int, catalog: Catalog): Catalog? =
        catalogRepository.updateCatalog(id, catalog)


}