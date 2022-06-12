package me.inassar.demos.features.chat.data.source

import kotlinx.coroutines.flow.Flow
import me.inassar.demos.features.auth.data.local.dao.UserEntity
import me.inassar.demos.features.chat.data.dao.MessageEntity

interface ChatDataSource {
    suspend fun getFriendList(sender: String): Flow<List<UserEntity>>
    suspend fun checkSessionAvailability(sender: String, receiver: String): String
    suspend fun insertMessage(messageEntity: MessageEntity)
    suspend fun getHistoryMessages(sender: String, receiver: String): Flow<List<MessageEntity>>
}