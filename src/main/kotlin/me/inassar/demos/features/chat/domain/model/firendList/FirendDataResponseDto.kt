package me.inassar.demos.features.chat.domain.model.firendList

@kotlinx.serialization.Serializable
data class FriendDataResponseDto(
    val token: String? = null,
    val friendInfo: FriendInfo? = null
)

@kotlinx.serialization.Serializable
data class FriendInfo(
    val username: String? = null,
    val email: String? = null
)
