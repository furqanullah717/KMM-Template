package com.codewithfk.eventhub.event.domain.model

import kotlinx.serialization.Serializable

@Serializable
data class Start(
    val dateTBA: Boolean,
    val dateTBD: Boolean,
    val dateTime: String,
    val localDate: String,
    val localTime: String,
    val noSpecificTime: Boolean,
    val timeTBA: Boolean
)