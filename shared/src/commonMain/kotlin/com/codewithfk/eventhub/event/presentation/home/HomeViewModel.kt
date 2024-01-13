package com.codewithfk.eventhub.event.presentation.home

import com.codewithfk.eventhub.event.domain.remote.EventService
import dev.icerock.moko.mvvm.viewmodel.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class HomeViewModel : ViewModel() {
    private val _state = MutableStateFlow<HomeViewStates>(HomeViewStates.Loading)
    val state: StateFlow<HomeViewStates?> = _state

    init {
        getData()
    }

    private fun getData() {
        viewModelScope.launch {
            _state.value = HomeViewStates.Loading
            val service = EventService.create()
            val response = service.getEvents(hashMapOf())
            if (response != null) {
                _state.value = HomeViewStates.Success(response._embedded.events)
            } else {
                _state.value = HomeViewStates.Error
            }

        }
    }


}