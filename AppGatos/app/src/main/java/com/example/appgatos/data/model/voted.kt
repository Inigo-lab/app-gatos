package com.example.appgatos.data.model


import com.squareup.moshi.Json

data class voted(
    @Json(name = "country_code")
    val countryCode: String?,
    @Json(name = "created_at")
    val createdAt: String?,
    @Json(name = "id")
    val id: Int?,
    @Json(name = "image")
    val image: ImageXX?,
    @Json(name = "image_id")
    val imageId: String?,
    @Json(name = "sub_id")
    val subId: String?,
    @Json(name = "value")
    val value: Int?
)