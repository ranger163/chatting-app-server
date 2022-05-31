package me.inassar.demos

import io.ktor.server.engine.*
import io.ktor.server.netty.*
import me.inassar.demos.plugins.*

fun main() {
    embeddedServer(Netty, port = 8080, host = "0.0.0.0") {
        configureJwt()
        configureRouting()
        configureSecurity()
        configureSerialization()
        configureSockets()
    }.start(wait = true)
}
