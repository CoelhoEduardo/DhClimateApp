package com.example.clima.views.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.clima.arquitetura.repository.EventsRepository
import com.example.clima.arquitetura.response.EventsResponse
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch

class MapViewModel(private val repository: EventsRepository = EventsRepository.instance) : ViewModel() {

    private val _events = MutableLiveData<EventsResponse>()
     val events: LiveData<EventsResponse>
        get() = _events

    private val _loading = MutableLiveData(false)
     val loading: LiveData<Boolean>
        get() = _loading


    private val _error = MutableLiveData(false)
     val error: LiveData<Boolean>
        get() = _error


    fun loadEvents() {
        viewModelScope.launch {
            repository.fetchProfile()
                .onStart { _loading.value = true }
                .catch { _error.value = true }
                .onCompletion { _loading.value = false }
                .collect {
                    _events.value = it

                }
        }
    }

    fun loadEventsFiltered(cat:String, status: String) {
        viewModelScope.launch {
            repository.fetchEventsFiltered(cat, status)
                .onStart { _loading.value = true }
                .catch { _error.value = true }
                .onCompletion { _loading.value = false }
                .collect {
                    _events.value= it

                }
        }
    }



}