package com.ananth.spacexapp

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform