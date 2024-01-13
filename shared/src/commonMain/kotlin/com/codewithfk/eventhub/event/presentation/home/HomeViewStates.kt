package com.codewithfk.eventhub.event.presentation.home

import com.codewithfk.eventhub.event.domain.model.Event

sealed class HomeViewStates {
    object Loading : HomeViewStates()
    class Success(val response: List<Event>) : HomeViewStates()
    object Error : HomeViewStates()
}