package me.inassar.demos.plugins

import io.ktor.server.application.*
import io.ktor.server.sessions.*
import me.inassar.demos.features.chat.resource.data.ChatSession
import java.util.*

fun Application.configureSecurity() {

    install(Sessions) {
        cookie<ChatSession>("MY_SESSION")
    }

    intercept(ApplicationCallPipeline.Plugins) {

        if (call.sessions.get<ChatSession>() == null) {
            val sender = call.parameters["sender"] ?: "Sender"
            val receiver = call.parameters["receiver"] ?: "Receiver"
            val sessionId = UUID.nameUUIDFromBytes((sender + receiver).toByteArray()).toString()

            call.sessions.set(
                ChatSession(
                    sender = sender,
                    receiver = receiver,
                    sessionId = sessionId
                )
            )
        }
    }
}
