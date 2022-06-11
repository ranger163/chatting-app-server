package me.inassar.demos.features.chat.data.source

import kotlinx.coroutines.flow.Flow
import me.inassar.demos.features.auth.data.local.dao.UserEntity
import me.inassar.demos.features.chat.data.dao.MessageEntity

interface ChatDataSource {
    suspend fun getFriendList(): Flow<List<UserEntity>>
    suspend fun insertMessage(messageEntity: MessageEntity)
    suspend fun getHistoryMessages(): Flow<List<MessageEntity>>
}