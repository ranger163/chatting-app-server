package me.inassar.demos.plugins

import io.ktor.server.application.*
import io.ktor.server.sessions.*
import me.inassar.demos.features.chat.data.dao.ChatSessionEntity
import me.inassar.demos.features.chat.domain.repository.ChatRepository
import org.koin.java.KoinJavaComponent.inject

fun Application.configureSecurity() {

    install(Sessions) {
        cookie<ChatSessionEntity>("MY_SESSION")
    }

    intercept(ApplicationCallPipeline.Plugins) {

        val chatRepository by inject<ChatRepository>(ChatRepository::class.java)

        if (call.sessions.get<ChatSessionEntity>() == null) {
            val sender = call.parameters["sender"].orEmpty()
            val receiver = call.parameters["receiver"].orEmpty()

            if (sender.isNotEmpty() && receiver.isNotEmpty()) {
                var sessionId = chatRepository.checkSessionAvailability(sender, receiver)

                if (sessionId.isNullOrEmpty())
                    sessionId = chatRepository.createNewSession(sender, receiver)

                call.sessions.set(
                    ChatSessionEntity(
                        sender = sender, receiver = receiver, sessionId = sessionId
                    )
                )
            }
        }
    }
}
