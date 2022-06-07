package me.inassar.demos.features.chat.data.source

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.toList
import me.inassar.demos.features.auth.data.local.dao.UserEntity
import org.litote.kmongo.coroutine.CoroutineDatabase

class ChatDataSourceImpl(database: CoroutineDatabase) : ChatDataSource {
    private val users = database.getCollection<UserEntity>()

    override suspend fun getFriendList(): Flow<List<UserEntity>> = flow {
        emit(users.find().toFlow().toList())
    }
}