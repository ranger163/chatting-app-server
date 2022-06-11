package me.inassar.demos.features.chat.resource.usecase

import io.ktor.server.sessions.*
import io.ktor.server.websocket.*
import io.ktor.websocket.*
import kotlinx.coroutines.channels.consumeEach
import me.inassar.demos.features.chat.domain.repository.ChatRepository
import me.inassar.demos.features.chat.resource.data.ChatSession
import me.inassar.demos.features.chat.resource.data.Message

class ConnectToSocketUseCase(private val repository: ChatRepository) {

    suspend operator fun invoke(webSocketServerSession: DefaultWebSocketServerSession) {
        webSocketServerSession.apply {
            val session = call.sessions.get<ChatSession>()

            if (session == null) {
                close(CloseReason(CloseReason.Codes.VIOLATED_POLICY, "No session found."))
                return@apply
            }

            try {
                repository.connectToSocket(session, this)

                incoming.consumeEach { frame ->
                    if (frame is Frame.Text) {
                        repository.sendMessage(
                            Message(
                                sessionId = session.sessionId,
                                textMessage = frame.readText(),
                                sender = session.sender,
                                receiver = session.receiver,
                                timestamp = System.currentTimeMillis()
                            )
                        )
                    }
                }
            } catch (e: Exception) {
                e.printStackTrace()
            } finally {
                repository.disconnectFromSocket(session.sender)
            }
        }
    }
}