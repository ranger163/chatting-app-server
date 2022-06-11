package me.inassar.demos.features.chat.data.dao

import org.bson.codecs.pojo.annotations.BsonId
import org.bson.types.ObjectId

data class MessageEntity(
    @BsonId
    val messageId: String = ObjectId().toString(),
    val sessionId: String,
    val textMessage: String,
    val sender: String,
    val receiver: String,
    val timestamp: Long
)
