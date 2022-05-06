package com.example.clima.arquitetura.repository

import com.example.clima.arquitetura.factory.DatabaseFactory
import com.example.clima.arquitetura.local.entity.EventsEntity
import com.example.clima.arquitetura.network.API
import com.example.clima.arquitetura.response.EventsResponse
import com.example.clima.arquitetura.response.toEventsEntity
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

    fun fetchLocalData(): Flow<List<EventsEntity>> = flow {
        val response = api.getEvents()
        DatabaseFactory.getDatabase().EventsDao().insertAll(response.events.map { it.toEventsEntity() })
        val events = DatabaseFactory.getDatabase().EventsDao().listAll()
        emit(events)
    }.flowOn(Dispatchers.IO)

    companion object {
        val instance by lazy { EventsRepository() }
    }
}
