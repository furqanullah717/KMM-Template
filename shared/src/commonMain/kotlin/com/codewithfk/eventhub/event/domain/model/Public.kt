package com.codewithfk.eventhub.event.domain.model

data class Public(
    val endDateTime: String,
    val startDateTime: String,
    val startTBA: Boolean,
    val startTBD: Boolean
)