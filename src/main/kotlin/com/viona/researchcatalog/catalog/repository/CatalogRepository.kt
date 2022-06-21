package com.viona.researchcatalog.catalog.repository

import com.viona.researchcatalog.catalog.entity.Catalog

interface CatalogRepository {

    fun getListCatalog(): List<Catalog>
}