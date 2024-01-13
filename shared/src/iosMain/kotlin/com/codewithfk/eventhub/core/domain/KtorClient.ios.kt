package com.codewithfk.eventhub.core.domain

import io.ktor.client.HttpClient
import io.ktor.client.HttpClientConfig
import io.ktor.client.engine.darwin.Darwin

actual fun httpClient(config: HttpClientConfig<*>.()-> Unit): HttpClient {
    return HttpClient(Darwin) {
        config(this)
        engine {
            configureRequest {
                setAllowsCellularAccess(true)
            }
        }
    }
}