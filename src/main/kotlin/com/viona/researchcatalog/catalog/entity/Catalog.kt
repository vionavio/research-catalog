package com.viona.researchcatalog.catalog.entity

data class Catalog(
    var id: Int = 0,
    var title: String = "",
    var category: String = "",
    var url: String = "",
    var iconUrl: String = "",
    var imageUrl: String = "",
    var description: String = ""
)