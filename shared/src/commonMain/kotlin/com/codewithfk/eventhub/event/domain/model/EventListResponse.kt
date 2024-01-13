package com.codewithfk.eventhub.event.domain.model

import kotlinx.serialization.Serializable

@Serializable
data class EventListResponse(
    val _embedded: Embedded,
)