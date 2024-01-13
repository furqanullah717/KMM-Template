package com.codewithfk.eventhub.event.data.remote

import com.codewithfk.eventhub.event.domain.model.EventModel
import com.codewithfk.eventhub.event.domain.remote.EventService
import com.codewithfk.eventhub.event.domain.remote.HttpRoutes
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get

class EventServiceImpl(val client: HttpClient) : EventService {
    override suspend fun getEvents(): List<EventModel> {
        return client.get(HttpRoutes.GET_EVENTS).body()
    }

    override suspend fun getEventById(id: Int): EventModel? {
        return client.get(HttpRoutes.getEventById(id)).body()
    }
}