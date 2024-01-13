package com.codewithfk.eventhub.event.domain.remote

import com.codewithfk.eventhub.core.domain.httpClient
import com.codewithfk.eventhub.event.data.remote.EventServiceImpl
import com.codewithfk.eventhub.event.domain.model.EventDetailsResponse
import com.codewithfk.eventhub.event.domain.model.EventListResponse
import com.codewithfk.eventhub.event.domain.model.EventModel
import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.DEFAULT
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

interface EventService {
    suspend fun getEvents(parameters: HashMap<String, String>): EventListResponse

    suspend fun getEventById(id: Int, parameters: HashMap<String, String>): EventDetailsResponse?

    companion object {
        fun create(): EventService {
            return EventServiceImpl(getHttpClient())
        }

        private fun getHttpClient(): HttpClient {
            return httpClient() {
                install(Logging) {
                    logger = Logger.DEFAULT
                    level = LogLevel.ALL
                }
                install(ContentNegotiation) {
                    json(
                        Json {
                            prettyPrint = true
                            isLenient = true
                            ignoreUnknownKeys = true
                        }
                    )
                }
            }
        }
    }
}