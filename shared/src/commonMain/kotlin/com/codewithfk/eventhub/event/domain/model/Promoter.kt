package com.codewithfk.eventhub.event.domain.model

import kotlinx.serialization.Serializable

@Serializable
data class Promoter(
    val description: String,
    val id: String,
    val name: String
)