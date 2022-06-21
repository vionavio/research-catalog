package com.viona.researchcatalog.catalog.repository

import com.viona.researchcatalog.catalog.entity.Catalog

interface CatalogRepository {

    fun getListCatalog(): List<Catalog>

    fun addCatalog(catalog: Catalog): List<Catalog>

    fun deleteCatalog(id: Int) : Catalog?

    fun getCatalogById(id: Int): Catalog?
}