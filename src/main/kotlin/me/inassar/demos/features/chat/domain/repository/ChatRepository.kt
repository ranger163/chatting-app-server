package me.inassar.demos.features.chat.domain.repository

import io.ktor.websocket.*
import kotlinx.coroutines.flow.Flow
import me.inassar.demos.features.auth.resource.data.User
import me.inassar.demos.features.chat.data.dao.ChatSessionEntity
import me.inassar.demos.features.chat.resource.data.Message

interface ChatRepository {
    suspend fun getFriendList(): Flow<List<User>>
    suspend fun checkSessionAvailability(sender: String, receiver: String): String?
    suspend fun createNewSession(sender: String, receiver: String): String
    suspend fun sendMessage(request: Message)
    suspend fun getHistoryMessages(sender: String, receiver: String): Flow<List<Message>>
    suspend fun connectToSocket(session: ChatSessionEntity?, socket: WebSocketSession)
    suspend fun disconnectFromSocket(sender: String)
}