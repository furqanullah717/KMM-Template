package com.codewithfk.eventhub.event.domain.model

data class Classification(
    val family: Boolean,
    val genre: Genre,
    val primary: Boolean,
    val segment: Segment,
    val subGenre: SubGenre,
    val subType: SubType,
    val type: Type
)