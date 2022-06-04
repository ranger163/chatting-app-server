package me.inassar.demos.features.chat.data.source

import me.inassar.demos.features.auth.data.local.dao.UserEntity
import org.litote.kmongo.coroutine.CoroutineDatabase

class ChatDataSourceImpl(database: CoroutineDatabase) : ChatDataSource {
    private val users = database.getCollection<UserEntity>()

    override suspend fun getUsers(): List<UserEntity> =
        users.find().toList()
}