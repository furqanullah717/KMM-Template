package com.codewithfk.eventhub.event.domain.model

import kotlinx.serialization.Serializable

@Serializable
data class VenueXX(
    val accessibleSeatingDetail: String,
    val address: Address,
    val id: String,
    val locale: String,
    val name: String,
    val postalCode: String,
    val test: Boolean,
    val timezone: String,
    val type: String,
    val url: String
)