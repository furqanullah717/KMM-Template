package com.codewithfk.eventhub.event.domain.model

import kotlinx.serialization.Serializable

@Serializable
data class Event(
    val _embedded: EmbeddedX?,
    val id: String?,
    val images: List<Image>?,
    val locale: String?,
    val name: String?,
    val type: String?,
    val url: String?
)