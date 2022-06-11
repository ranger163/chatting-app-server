package me.inassar.demos.features.chat.resource.data

@kotlinx.serialization.Serializable
data class Message(
    val sessionId: String,
    val textMessage: String,
    val sender: String,
    val receiver: String,
    val timestamp: Long
)
