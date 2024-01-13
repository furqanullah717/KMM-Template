package com.codewithfk.eventhub.event.domain.model

import kotlinx.serialization.Serializable

@Serializable
data class EventsLocation(
    val venues: List<VenueXX>
)