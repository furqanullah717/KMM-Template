package com.codewithfk.eventhub.event.domain.model

import kotlinx.serialization.Serializable

@Serializable
data class EmbeddedX(
    val attractions: List<Attraction>?,
    val venues: List<Venue>?
)