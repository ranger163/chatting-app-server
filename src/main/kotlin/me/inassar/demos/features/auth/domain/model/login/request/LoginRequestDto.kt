package me.inassar.demos.features.auth.domain.model.login.request

@kotlinx.serialization.Serializable
data class LoginRequestDto(
    val email: String? = null,
    val password: String? = null
)
