package com.codewithfk.eventhub.event.domain

import com.codewithfk.eventhub.core.domain.httpClient
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.DEFAULT
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.request.HttpRequestBuilder
import io.ktor.client.request.get
import io.ktor.client.request.parameter
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.client.request.url
import io.ktor.client.statement.HttpResponse
import io.ktor.client.statement.bodyAsText
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

object NetworkHandler {
    private const val API_KEY = ""
    private const val BASE_URL = "https://app.thefk.com"
    private const val EVENTS_ENDPOINT = "/discovery/v2/events.json"
    private const val EVENT_DETAILS_ENDPOINT = "/discovery/v2/events/"
    private val kTorClient = httpClient() {
        install(Logging) {
            logger = Logger.DEFAULT
            level = LogLevel.ALL
        }
        install(ContentNegotiation) {
            json(Json {
                prettyPrint = true
                isLenient = true
                ignoreUnknownKeys = true
            })
        }
    }
    private suspend fun getEventDetails(
        endPoint: String,
        id:String
    ): HttpResponse? {
        val baseUrl = "$BASE_URL$endPoint/$id"
        return  kTorClient.get(baseUrl) {
            parameter("apikey", API_KEY)
        }.body()
    }

    private suspend fun fetchEvents(
        endPoint: String,
        params: Map<String, String>?
    ): HttpResponse {
        val baseUrl = "$BASE_URL$endPoint"
        return  kTorClient.get(baseUrl) {
            params?.forEach {
                parameter(it.key, it.value)
            }
            parameter("apikey", API_KEY)
        }.body()
    }


    suspend fun createEventsUrl(): HttpResponse? {
        return fetchEvents(EVENTS_ENDPOINT, null)
    }

    suspend fun getEventDetails(id:String): HttpResponse? {
        return getEventDetails(EVENT_DETAILS_ENDPOINT, id)
    }

}