package com.codewithfk.eventhub.event.domain.model

data class Sales(
    val presales: List<Presale>,
    val `public`: Public
)