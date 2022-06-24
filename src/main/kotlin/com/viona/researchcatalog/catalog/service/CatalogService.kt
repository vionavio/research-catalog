package com.viona.researchcatalog.catalog.service

import com.viona.researchcatalog.catalog.entity.Catalog

interface CatalogService {

    fun getListCatalog(): List<Catalog>

    fun addCatalog(catalog: Catalog): List<Catalog>

    fun deleteCatalog(id: Int)

    fun getCatalogById(id: Int): Catalog?

    fun updateCatalog(id: Int, catalog: Catalog): Catalog?
}