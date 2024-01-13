package com.codewithfk.eventhub.event.domain.model

data class Product(
    val classifications: List<Classification>,
    val id: String,
    val name: String,
    val type: String,
    val url: String
)