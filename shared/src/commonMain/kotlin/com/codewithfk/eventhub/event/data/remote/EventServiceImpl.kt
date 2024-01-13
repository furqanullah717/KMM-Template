package com.codewithfk.eventhub.event.data.remote

import com.codewithfk.eventhub.event.domain.model.EventDetailsResponse
import com.codewithfk.eventhub.event.domain.model.EventListResponse
import com.codewithfk.eventhub.event.domain.model.EventModel
import com.codewithfk.eventhub.event.domain.remote.EventService
import com.codewithfk.eventhub.event.domain.remote.HttpRoutes
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.parameter

class EventServiceImpl(val client: HttpClient) : EventService {
    override suspend fun getEvents(parameters: HashMap<String, String>): EventListResponse {
        return client.get(HttpRoutes.GET_EVENTS) {
            parameters.forEach { (key, value) ->
                parameter(key, value)
            }
            parameter("apikey", HttpRoutes.API_KEY)
        }.body()
    }

    override suspend fun getEventById(
        id: Int,
        parameters: HashMap<String, String>
    ): EventDetailsResponse? {
        return client.get(HttpRoutes.GET_EVENT_BY_ID) {
            parameters.forEach { (key, value) ->
                parameter(key, value)
            }
            parameter("apikey", HttpRoutes.API_KEY)
        }.body()
    }
}