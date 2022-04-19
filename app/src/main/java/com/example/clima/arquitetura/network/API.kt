package com.example.clima.arquitetura.network

import com.example.clima.arquitetura.factory.GsonFactory
import com.example.clima.arquitetura.factory.OkHttpClientFactory
import com.example.clima.arquitetura.factory.RetrofitFactory
import com.example.clima.arquitetura.response.EventsResponse
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.Query


interface API {

    @GET("events")
    @Headers("Accept: application/json")
    suspend fun getEvents(
        @Query("limit") limit: Int = 50,
        @Query("days") days: Int = 20,
        @Header("Content-Type") content: String = "application/json"
    ) : EventsResponse


    companion object {
        val instance: API by lazy {
            RetrofitFactory.build(
                OkHttpClientFactory.build(),
                GsonFactory.build()
            ).create(API::class.java)
        }
    }
}