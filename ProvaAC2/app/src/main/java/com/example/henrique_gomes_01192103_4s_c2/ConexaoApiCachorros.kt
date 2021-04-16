package com.example.henrique_gomes_01192103_4s_c2

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ConexaoApiCachorros {

    fun criar(): ApiCachorros{
        return Retrofit.Builder()
            .baseUrl("https://5f861cfdc8a16a0016e6aacd.mockapi.io/bandtec-api/cachorros")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiCachorros::class.java)
    }
}