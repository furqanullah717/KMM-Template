package com.codewithfk.eventhub.event.domain.model

import kotlinx.serialization.Serializable

@Serializable
data class Dates(
    val spanMultipleDays: Boolean,
    val start: Start,
    val status: Status,
    val timezone: String
)