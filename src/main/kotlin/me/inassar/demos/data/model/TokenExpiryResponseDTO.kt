package me.inassar.demos.data.model

@kotlinx.serialization.Serializable
data class TokenExpiryResponseDTO(
    val data: String? = null,
    val error: Error? = Error()
) {
    @kotlinx.serialization.Serializable
    data class Error(
        val message: String = "Token is not valid or has been expired."
    )
}