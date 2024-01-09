package com.example.appgatos.data.model


import com.squareup.moshi.Json

data class ImageX(
    @Json(name = "id")
    val id: String?,
    @Json(name = "url")
    val url: String?
)