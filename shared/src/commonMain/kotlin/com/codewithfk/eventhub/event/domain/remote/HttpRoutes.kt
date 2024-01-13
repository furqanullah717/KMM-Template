package com.codewithfk.eventhub.event.domain.remote

object HttpRoutes {
    const val BASE_URL = "https://jsonplaceholder.typicode.com"
    const val GET_EVENTS = "$BASE_URL/posts"
    const val GET_EVENT_BY_ID = "$BASE_URL/posts/{id}"

    fun getEventById(id: Int): String {
        return GET_EVENT_BY_ID.replace("{id}", id.toString())
    }

}