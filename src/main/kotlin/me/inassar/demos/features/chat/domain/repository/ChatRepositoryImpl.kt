package me.inassar.demos.features.chat.domain.repository

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import me.inassar.demos.data.repository.JwtRepository
import me.inassar.demos.features.auth.domain.mapper.toUser
import me.inassar.demos.features.auth.resource.data.User
import me.inassar.demos.features.chat.data.source.ChatDataSource

class ChatRepositoryImpl(
    private val datasource: ChatDataSource, private val jwtRepository: JwtRepository
) : ChatRepository {
    override suspend fun getFriendList(): Flow<List<User>> = flow {
        datasource.getFriendList().collect { friendList ->
            val friendListResult = friendList.filter { friendEntity ->
                friendEntity.email != jwtRepository.getEmailPayload()
            }.map { it.toUser() }
            emit(friendListResult)
        }
    }
}