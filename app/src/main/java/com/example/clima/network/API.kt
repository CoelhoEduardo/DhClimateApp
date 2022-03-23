package com.example.clima.network

import com.example.clima.Model.Maps.EventsResponse
import com.example.clima.data.factory.GsonFactory
import com.example.clima.data.factory.OkHttpClientFactory
import com.example.clima.data.factory.RetrofitFactory
import retrofit2.http.GET

interface API {

    @GET("api/v3/events")
    suspend fun getEvents() : EventsResponse


    companion object {
        val instance: API by lazy {
            RetrofitFactory.build(
                OkHttpClientFactory.build(),
                GsonFactory.build()
            ).create(API::class.java)
        }
    }
}