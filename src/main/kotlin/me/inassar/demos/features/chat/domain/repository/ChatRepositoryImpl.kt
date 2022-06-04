package me.inassar.demos.features.chat.domain.repository

import me.inassar.demos.features.auth.domain.mapper.toUser
import me.inassar.demos.features.auth.resource.data.User
import me.inassar.demos.features.chat.data.source.ChatDataSource

class ChatRepositoryImpl(private val datasource: ChatDataSource) : ChatRepository {
    override suspend fun getUsers(): List<User> = datasource.getUsers().map { it.toUser() }
}