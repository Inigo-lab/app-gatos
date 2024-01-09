package com.example.appgatos.data.model


import com.squareup.moshi.Json

data class votadoItem(
    @field:Json(name = "country_code")
    val countryCode: String?,
    @field:Json(name = "created_at")
    val createdAt: String?,
    @field:Json(name = "id")
    val id: Int?,
    @field:Json(name = "image")
    val image: ImageX?,
    @field:Json(name = "image_id")
    val imageId: String?,
    @field:Json(name = "sub_id")
    val subId: String?,
    @field:Json(name = "value")
    val value: Int?
)