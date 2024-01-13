package com.codewithfk.eventhub.event.domain.model

data class ImageX(
    val fallback: Boolean,
    val height: Int,
    val ratio: String,
    val url: String,
    val width: Int
)