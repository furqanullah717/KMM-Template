package com.codewithfk.eventhub.event.domain.model

import com.codewithfk.eventhub.event.domain.model.AttractionX
import com.codewithfk.eventhub.event.domain.model.Self
import com.codewithfk.eventhub.event.domain.model.VenueX

data class LinksXX(
    val attractions: List<AttractionX>,
    val self: Self,
    val venues: List<VenueX>
)