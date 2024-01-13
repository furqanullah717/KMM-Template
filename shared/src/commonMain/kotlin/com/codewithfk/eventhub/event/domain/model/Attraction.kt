package com.codewithfk.eventhub.event.domain.model

import kotlinx.serialization.Serializable

@Serializable
data class Attraction(
    val url: String?
)