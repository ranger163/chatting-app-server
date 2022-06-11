package me.inassar.demos.features.chat.domain.mapper

import me.inassar.demos.features.auth.resource.data.User
import me.inassar.demos.features.chat.data.dao.MessageEntity
import me.inassar.demos.features.chat.domain.model.chatRoom.response.MessageResponseDto
import me.inassar.demos.features.chat.domain.model.firendList.FriendDataResponseDto
import me.inassar.demos.features.chat.domain.model.firendList.FriendInfo
import me.inassar.demos.features.chat.resource.data.Message

fun User.toFriendData() = FriendDataResponseDto(
    token = token,
    friendInfo = FriendInfo(
        username = user?.username,
        email = user?.email,
        avatar = user?.avatar
    )
)

fun Message.toMessageEntity() = MessageEntity(
    sessionId = sessionId,
    textMessage = textMessage,
    sender = sender,
    receiver = receiver,
    timestamp = timestamp,
)

fun Message.toMessageResponseDto() = MessageResponseDto(
    textMessage = textMessage,
    sender = sender,
    receiver = receiver,
    timestamp = timestamp,
)

fun MessageEntity.toMessage() = Message(
    sessionId = sessionId,
    textMessage = textMessage,
    sender = sender,
    receiver = receiver,
    timestamp = timestamp,
)