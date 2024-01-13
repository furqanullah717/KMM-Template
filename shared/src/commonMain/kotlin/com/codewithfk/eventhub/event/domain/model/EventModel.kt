package com.codewithfk.eventhub.event.domain.model

import kotlinx.serialization.Serializable

@Serializable
data class EventModel(
    val body: String,
    val id: Int,
    val title: String,
    val userId: Int
)