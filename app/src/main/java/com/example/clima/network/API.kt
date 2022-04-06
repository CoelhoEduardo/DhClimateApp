package com.example.clima.network

import android.telecom.Call
import com.example.clima.Model.Maps.EventsResponse
import com.example.clima.data.factory.GsonFactory
import com.example.clima.data.factory.OkHttpClientFactory
import com.example.clima.data.factory.RetrofitFactory
import com.google.android.gms.common.api.Api
import retrofit2.http.GET
import retrofit2.http.Query

interface API {

    @GET("events")
    suspend fun getEvents(
        //@Query("2Xtwkhkp8GGB5O4Vnf2ayCGnRbb3w3cRDZwTo6cU") events: String
        //@Query("") api_id: String

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