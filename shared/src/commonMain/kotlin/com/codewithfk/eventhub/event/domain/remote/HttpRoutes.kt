package com.codewithfk.eventhub.event.domain.remote

object HttpRoutes {
    const val BASE_URL = "https://app.ticketmaster.com"
    const val GET_EVENTS = "$BASE_URL/discovery/v2/events.json"
    const val GET_EVENT_BY_ID = "$BASE_URL/discovery/v2/events/"
    const val API_KEY = "Kv9uInIsbKqAH4kuYUajU4ABjxUKsLzP"

}