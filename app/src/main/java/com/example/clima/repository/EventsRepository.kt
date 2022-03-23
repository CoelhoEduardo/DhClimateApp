package com.example.clima.repository

import com.example.clima.network.API
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class EventsRepository(private val  api: API = API.instance) {
    fun fetchProfile() = flow {
        emit(api.getEvents(""))
    }.flowOn(Dispatchers.IO)

    companion object {
        val instance by lazy { EventsRepository() }
    }
}