package me.inassar.demos.data.model

@kotlinx.serialization.Serializable
data class User(
    val username: String? = null,
    val email: String,
    val password: String
)
