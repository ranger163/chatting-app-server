package me.inassar.demos.features.chat.domain.repository

import kotlinx.coroutines.flow.Flow
import me.inassar.demos.features.auth.resource.data.User

interface ChatRepository {
    suspend fun getFriendList(): Flow<List<User>>
}