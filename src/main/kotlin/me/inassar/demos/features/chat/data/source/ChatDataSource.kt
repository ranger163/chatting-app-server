package me.inassar.demos.features.chat.data.source

import kotlinx.coroutines.flow.Flow
import me.inassar.demos.features.auth.data.local.dao.UserEntity

interface ChatDataSource {
    suspend fun getFriendList(): Flow<List<UserEntity>>
}