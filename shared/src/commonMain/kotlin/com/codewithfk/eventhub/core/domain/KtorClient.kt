package com.codewithfk.eventhub.core.domain

import io.ktor.client.HttpClient
import io.ktor.client.HttpClientConfig


expect fun httpClient(config: HttpClientConfig<*>.()-> Unit={}): HttpClient