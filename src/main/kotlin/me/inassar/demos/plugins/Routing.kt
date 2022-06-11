package me.inassar.demos.plugins

import io.ktor.server.application.*
import io.ktor.server.auth.*
import io.ktor.server.routing.*
import me.inassar.demos.features.auth.resource.loginEndpoint
import me.inassar.demos.features.auth.resource.signupEndpoint
import me.inassar.demos.features.chat.resource.chatConnectEndpoint
import me.inassar.demos.features.chat.resource.chatHistoryEndpoint
import me.inassar.demos.features.chat.resource.friendsListEndpoint

fun Application.configureRouting() {

    install(Routing) {

        signupEndpoint()
        loginEndpoint()

        authenticate("auth-jwt") {
            chatConnectEndpoint()
            friendsListEndpoint()
            chatHistoryEndpoint()
        }
    }
}
