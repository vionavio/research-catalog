package com.viona.researchcatalog.catalog.controller

import com.viona.researchcatalog.base.BaseResponse
import com.viona.researchcatalog.catalog.entity.Catalog
import com.viona.researchcatalog.catalog.service.CatalogService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("v1/catalog")
class CatalogController {

    @Autowired
    private lateinit var catalogService: CatalogService

    @GetMapping
    fun getListCatalog(): BaseResponse<List<Catalog>> =
        BaseResponse(
            status = true,
            message = "Success",
            data = catalogService.getListCatalog()
        )
}