package com.viona.researchcatalog.catalog.service

import com.viona.researchcatalog.catalog.entity.Catalog

interface CatalogService {

    fun getListCatalog(): List<Catalog>
}