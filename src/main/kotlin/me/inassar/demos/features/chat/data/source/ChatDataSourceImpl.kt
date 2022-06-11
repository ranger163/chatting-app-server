package me.inassar.demos.features.chat.data.source

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.toList
import me.inassar.demos.features.auth.data.local.dao.UserEntity
import me.inassar.demos.features.chat.data.dao.MessageEntity
import org.litote.kmongo.coroutine.CoroutineDatabase

class ChatDataSourceImpl(database: CoroutineDatabase) : ChatDataSource {
    private val users = database.getCollection<UserEntity>()
    private val messages = database.getCollection<MessageEntity>()


    override suspend fun getFriendList(): Flow<List<UserEntity>> = flow {
        emit(users.find().toFlow().toList())
    }

    override suspend fun insertMessage(messageEntity: MessageEntity) {
        messages.insertOne(messageEntity)
    }

    override suspend fun getHistoryMessages(): Flow<List<MessageEntity>> = flow {
        emit(messages.find().descendingSort(MessageEntity::timestamp).toList())
    }
}