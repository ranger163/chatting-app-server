package me.inassar.demos.features.auth.domain.model.signup.request

@kotlinx.serialization.Serializable
data class SignupRequestDto(
    val username: String? = null,
    val email: String? = null,
    val password: String? = null
)
