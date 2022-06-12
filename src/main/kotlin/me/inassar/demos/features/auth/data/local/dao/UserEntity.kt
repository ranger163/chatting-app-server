package me.inassar.demos.features.auth.data.local.dao

import me.inassar.demos.features.chat.resource.data.Message
import org.bson.codecs.pojo.annotations.BsonId
import org.bson.types.ObjectId

@kotlinx.serialization.Serializable
data class UserEntity(
    @BsonId
    val id: String = ObjectId().toString(),
    val token: String? = null,
    val username: String? = null,
    val email: String? = null,
    val avatar: String? = null,
    val password: String? = null,
    val lastMessage: Message? = null
)
