package me.inassar.demos.features.auth.resource.data

@kotlinx.serialization.Serializable
data class User(
    val token: String? = null,
    val user: UserData? = null
)

@kotlinx.serialization.Serializable
data class UserData(
    val username: String? = null,
    val email: String? = null
)
