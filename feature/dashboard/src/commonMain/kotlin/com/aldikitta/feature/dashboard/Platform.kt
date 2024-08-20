package com.aldikitta.feature.dashboard

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform