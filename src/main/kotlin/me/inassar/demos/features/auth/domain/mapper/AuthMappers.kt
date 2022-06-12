package me.inassar.demos.features.auth.domain.mapper

import me.inassar.demos.features.auth.data.local.dao.UserEntity
import me.inassar.demos.features.auth.domain.model.signup.request.SignupRequestDto
import me.inassar.demos.features.auth.resource.data.User
import me.inassar.demos.features.auth.resource.data.UserData

/**
 * This file contains mapper functions to help map values
 * easily through all app's layers.
 */

fun SignupRequestDto.toUserEntity() = UserEntity(
    username = username, email = email, password = password
)

fun UserEntity.toUser() = User(
    token = token,
    user = UserData(
        username = username,
        email = email,
        avatar = avatar,
        lastMessage = lastMessage
    )
)