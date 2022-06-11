package me.inassar.demos.features.chat.domain.repository

import io.ktor.websocket.*
import kotlinx.coroutines.flow.Flow
import me.inassar.demos.features.auth.resource.data.User
import me.inassar.demos.features.chat.resource.data.ChatSession
import me.inassar.demos.features.chat.resource.data.Message

interface ChatRepository {
    suspend fun getFriendList(): Flow<List<User>>
    suspend fun sendMessage(request: Message)
    suspend fun getHistoryMessages(sessionId: String): Flow<List<Message>>
    suspend fun connectToSocket(session: ChatSession?, socket: WebSocketSession)
    suspend fun disconnectFromSocket(sender: String)
}