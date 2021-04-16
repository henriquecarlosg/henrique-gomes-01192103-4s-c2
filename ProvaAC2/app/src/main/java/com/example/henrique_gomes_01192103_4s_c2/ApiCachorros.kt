package com.example.henrique_gomes_01192103_4s_c2

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import java.util.List

interface ApiCachorros {

    @GET("cachorros")
    fun get(): Call<List<Cachorro>>

    @POST("cachorros")
    fun post(@Body novoCachorro:Cachorro): Call<Cachorro>
}