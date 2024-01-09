package com.example.appgatos.data

import android.content.Context
import com.example.appgatos.data.model.Rate
import com.example.appgatos.data.network.RetrofitHelper

class Repository(val context: Context) {

    private val apiService = RetrofitHelper.getRetrofit()

    suspend fun getBreeds() = apiService.getAllBreeds()

    suspend fun buscarNombre(nombre : String) = apiService.buscarNombre(nombre)

    suspend fun votar(rate: Rate) = apiService.votar(rate)

    suspend fun votado(id_img: String) = apiService.votado(id_img)
}