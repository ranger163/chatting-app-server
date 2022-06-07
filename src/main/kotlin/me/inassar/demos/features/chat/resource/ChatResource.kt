package me.inassar.demos.features.chat.resource

import io.ktor.server.application.*
import io.ktor.server.auth.*
import io.ktor.server.auth.jwt.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import me.inassar.demos.common.ENDPOINT_CHAT_HISTORY
import me.inassar.demos.common.ENDPOINT_FRIEND_LIST
import me.inassar.demos.features.chat.resource.usecase.FriendListUseCase
import org.koin.java.KoinJavaComponent.inject

fun Route.friendsListEndpoint() {
    val useCase by inject<FriendListUseCase>(FriendListUseCase::class.java)
    get(ENDPOINT_FRIEND_LIST) {
        useCase().collect { response ->
            call.respond(response)
        }
    }
}

fun Route.chatRoomEndpoint() {
    get(ENDPOINT_CHAT_HISTORY) {
        val principal = call.principal<JWTPrincipal>()
        val data = principal!!.payload.getClaim("data").asMap()

        call.respond(data)
    }
}