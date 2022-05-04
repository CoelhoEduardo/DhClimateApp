package com.example.clima.arquitetura.repository

import com.example.clima.arquitetura.network.API
import com.example.clima.arquitetura.response.EventsResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class EventsRepository(private val api: API = API.instance) {
    fun fetchProfile(): Flow<EventsResponse> = flow {
        emit(api.getEvents())
    }.flowOn(Dispatchers.IO)

    fun fetchEventsFiltered(cat: String, status: String): Flow<EventsResponse> = flow {
        emit(api.getEventsFiltered(cat, status))
    }.flowOn(Dispatchers.IO)

    companion object {
        val instance by lazy { EventsRepository() }
    }
}