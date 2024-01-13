package com.codewithfk.eventhub.event.domain.model

data class Page(
    val number: Int,
    val size: Int,
    val totalElements: Int,
    val totalPages: Int
)