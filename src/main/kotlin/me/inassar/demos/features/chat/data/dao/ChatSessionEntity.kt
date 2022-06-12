package me.inassar.demos.features.chat.data.dao

import org.bson.codecs.pojo.annotations.BsonId
import org.bson.types.ObjectId

data class ChatSessionEntity(
    @BsonId
    val id: String = ObjectId().toString(),
    val sender: String,
    val receiver: String,
    val sessionId: String
)
