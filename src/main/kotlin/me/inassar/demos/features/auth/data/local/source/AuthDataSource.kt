package me.inassar.demos.features.auth.data.local.source

import me.inassar.demos.features.auth.data.local.dao.UserEntity

interface AuthDataSource {
    suspend fun insertUser(userEntity: UserEntity): UserEntity
    suspend fun findUserByEmail(email: String): UserEntity?
}