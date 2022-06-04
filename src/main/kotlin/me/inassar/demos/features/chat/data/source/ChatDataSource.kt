package me.inassar.demos.features.chat.data.source

import me.inassar.demos.features.auth.data.local.dao.UserEntity

interface ChatDataSource {
    suspend fun getUsers(): List<UserEntity>
}