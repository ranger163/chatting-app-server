package me.inassar.demos.features.chat.resource.data

data class ChatSession(
    val sender: String,
    val receiver: String,
    val sessionId: String
)
