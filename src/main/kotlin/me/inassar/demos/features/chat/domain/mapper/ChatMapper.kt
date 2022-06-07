package me.inassar.demos.features.chat.domain.mapper

import me.inassar.demos.features.auth.resource.data.User
import me.inassar.demos.features.chat.domain.model.firendList.FriendDataResponseDto
import me.inassar.demos.features.chat.domain.model.firendList.FriendInfo

fun User.toFriendData() = FriendDataResponseDto(
    token = token,
    friendInfo = FriendInfo(
        username = user?.username,
        email = user?.email,
        avatar = user?.avatar
    )
)