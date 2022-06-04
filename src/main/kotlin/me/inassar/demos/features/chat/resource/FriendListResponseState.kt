package me.inassar.demos.features.chat.resource

import me.inassar.demos.features.chat.domain.model.firendList.FriendDataResponseDto

@kotlinx.serialization.Serializable
data class FriendListResponseState(
    val data: List<FriendDataResponseDto>? = null,
    val error: HashMap<String, String>? = null
)
