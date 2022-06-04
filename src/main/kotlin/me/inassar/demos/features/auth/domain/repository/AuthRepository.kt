package me.inassar.demos.features.auth.domain.repository

import me.inassar.demos.features.auth.domain.model.signup.request.SignupRequestDto
import me.inassar.demos.features.auth.data.local.dao.UserEntity
import me.inassar.demos.features.auth.resource.data.User

interface AuthRepository {
    suspend fun insertUser(request: SignupRequestDto, token: String): User
    suspend fun getUser(email: String): UserEntity?
}