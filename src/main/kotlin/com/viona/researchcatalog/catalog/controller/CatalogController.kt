package com.viona.researchcatalog.catalog.controller

import com.viona.researchcatalog.base.BaseResponse
import com.viona.researchcatalog.catalog.entity.Catalog
import com.viona.researchcatalog.catalog.service.CatalogService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*


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

    @PostMapping
    fun addCatalog(
        @RequestBody catalog: Catalog
    ): BaseResponse<List<Catalog>> =
        BaseResponse(
            status = true,
            message = "Success",
            data = catalogService.addCatalog(catalog)
        )

    @DeleteMapping("/{id}")
    fun deleteCatalog(
        @PathVariable(value = "id") id: Int
    ): BaseResponse<Catalog?> = BaseResponse(
        status = true,
        message = "success",
        data = catalogService.deleteCatalog(id)
    )

    @GetMapping("/{id}")
    fun getCatalogById(
        @PathVariable(value = "id") id: Int
    ): BaseResponse<Catalog?> = BaseResponse(
        status = true,
        message = "success",
        data = catalogService.getCatalogById(id)
    )

    @PutMapping("/{id}")
    fun updateCatalog(
        @RequestBody catalog: Catalog,
        @PathVariable("id") id: Int
    ): BaseResponse<Catalog?> = BaseResponse(
        status = true,
        message = "success",
        data = catalogService.updateCatalog(id, catalog)
    )

}