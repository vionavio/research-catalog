package com.viona.researchcatalog.base

data class BaseResponse<T>(
    var status: Boolean = false,
    var message: String = "",
    var data: T
)