package me.inassar.demos.features.chat.resource

import me.inassar.demos.features.chat.domain.model.chatRoom.response.MessageResponseDto


@kotlinx.serialization.Serializable
data class ChatRoomHistoryState(
    val data: List<MessageResponseDto>? = null,
    val error: HashMap<String, String>? = null
)
