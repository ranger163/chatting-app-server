package me.inassar.demos.features.auth.resource.data

import me.inassar.demos.features.chat.resource.data.Message

@kotlinx.serialization.Serializable
data class User(
    val token: String? = null,
    val user: UserData? = null
)

@kotlinx.serialization.Serializable
data class UserData(
    val username: String? = null,
    val email: String? = null,
    val avatar: String? = null,
    val lastMessage: Message? = null
)
