package com.codewithfk.eventhub

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform