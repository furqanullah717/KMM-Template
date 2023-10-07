package com.codewithfk.eventhub.core.domain

import io.ktor.client.HttpClient
import io.ktor.client.HttpClientConfig


private const val TIME_OUT = 60_000

expect fun  httpClient(config: HttpClientConfig<*>.()-> Unit={}):HttpClient