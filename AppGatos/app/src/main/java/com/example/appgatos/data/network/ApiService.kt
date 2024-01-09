package com.example.appgatos.data.network

import com.example.appgatos.data.model.GatosItem
import com.example.appgatos.data.model.Rate
import com.example.appgatos.data.model.votadoItem
import com.example.appgatos.data.model.votos
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.POST
import retrofit2.http.Query

interface ApiService {

    @Headers("x-api-key: live_mypvrai50zT0QXrRhNySclOweZljfq5Q82SjWqd7TnYlpgCZZ6WKJvVL0IxYbZY8")
    @GET("breeds")
    suspend fun getAllBreeds() : Response<List<GatosItem>>

    @Headers("x-api-key: live_mypvrai50zT0QXrRhNySclOweZljfq5Q82SjWqd7TnYlpgCZZ6WKJvVL0IxYbZY8")
    @GET("character")
    suspend fun buscarNombre(@Query("name") nombre: String) : Response<List<GatosItem>>

    @Headers("x-api-key: live_mypvrai50zT0QXrRhNySclOweZljfq5Q82SjWqd7TnYlpgCZZ6WKJvVL0IxYbZY8","Content-Type: application/json")
    @POST("votes")
    suspend fun votar(
        @Body rate: Rate
    ) : Response<votos>

    @Headers("x-api-key: live_mypvrai50zT0QXrRhNySclOweZljfq5Q82SjWqd7TnYlpgCZZ6WKJvVL0IxYbZY8","Content-Type: application/json")
    @GET("votes")
    suspend fun votado(
        @Query("sub_id") id_img : String
    ): Response<List<Rate>>
}