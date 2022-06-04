package me.inassar.demos.features.chat.resource.usecase

import me.inassar.demos.features.chat.domain.mapper.toFriendData
import me.inassar.demos.features.chat.domain.repository.ChatRepository
import me.inassar.demos.features.chat.resource.FriendListResponseState

class FriendListUseCase(private val repository: ChatRepository) {

    suspend operator fun invoke(): FriendListResponseState =
        if (repository.getUsers().isNotEmpty()) {
            FriendListResponseState(data = repository.getUsers().map { it.toFriendData() }, error = null)
        } else {
            FriendListResponseState(data = emptyList(), error = null)
        }

}