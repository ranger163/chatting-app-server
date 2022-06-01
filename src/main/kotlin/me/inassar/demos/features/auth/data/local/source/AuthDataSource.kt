package me.inassar.demos.features.auth.data.local.source

import me.inassar.demos.features.auth.data.local.dao.UserEntity

interface AuthDataSource {
    suspend fun insertUser(userEntity: UserEntity): UserEntity
    suspend fun getSingleUser(email: String): UserEntity?
    suspend fun getUsers(): List<UserEntity>
}