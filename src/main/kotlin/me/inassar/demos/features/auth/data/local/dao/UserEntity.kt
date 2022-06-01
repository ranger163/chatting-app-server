package me.inassar.demos.features.auth.data.local.dao

import org.bson.codecs.pojo.annotations.BsonId
import org.bson.types.ObjectId

@kotlinx.serialization.Serializable
data class UserEntity(
    @BsonId
    val id: String = ObjectId().toString(),
    val token: String? = null,
    val username: String? = null,
    val email: String? = null,
    val password: String? = null
)
