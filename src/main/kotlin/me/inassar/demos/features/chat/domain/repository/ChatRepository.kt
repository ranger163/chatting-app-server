package me.inassar.demos.features.chat.domain.repository

import me.inassar.demos.features.auth.resource.data.User

interface ChatRepository {
    suspend fun getUsers(): List<User>
}