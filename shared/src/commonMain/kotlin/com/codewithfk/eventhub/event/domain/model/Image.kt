package com.codewithfk.eventhub.event.domain.model

import kotlinx.serialization.Serializable

@Serializable
data class Image(
    val fallback: Boolean?,
    val height: Int,
    val ratio: String,
    val url: String,
    val width: Int
)