package com.codewithfk.eventhub.core.domain

import io.ktor.client.HttpClient
import io.ktor.client.HttpClientConfig
import io.ktor.client.engine.okhttp.OkHttp

actual fun httpClient(config: HttpClientConfig<*>.()-> Unit): HttpClient {
    return HttpClient(OkHttp) {
        config(this)
        engine {
            config {
                retryOnConnectionFailure(true)
                connectTimeout(5, java.util.concurrent.TimeUnit.SECONDS)
            }
        }
    }
}