package me.inassar.demos.features.chat.resource.usecase

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import me.inassar.demos.data.repository.JwtRepository
import me.inassar.demos.features.chat.domain.mapper.toMessageResponseDto
import me.inassar.demos.features.chat.domain.repository.ChatRepository
import me.inassar.demos.features.chat.resource.ChatRoomHistoryState
import java.util.*

class GetHistoryMessagesUseCase(private val repository: ChatRepository, private val jwtRepository: JwtRepository) {

    suspend operator fun invoke(receiver: String): Flow<ChatRoomHistoryState> = flow {

        val sessionId = UUID.nameUUIDFromBytes(
            (jwtRepository.getEmailPayload() + receiver).toByteArray()
        ).toString()

        repository.getHistoryMessages(sessionId = sessionId)
            .collect { messageList ->
                val result = if (messageList.isNotEmpty()) {
                    ChatRoomHistoryState(data = messageList.map { it.toMessageResponseDto() }, error = null)
                } else {
                    ChatRoomHistoryState(data = emptyList(), error = null)
                }
                emit(result)
            }
    }
}