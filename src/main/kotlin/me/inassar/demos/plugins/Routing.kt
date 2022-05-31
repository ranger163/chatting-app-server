package me.inassar.demos.plugins

import com.auth0.jwt.JWT
import com.auth0.jwt.algorithms.Algorithm
import io.ktor.server.application.*
import io.ktor.server.auth.*
import io.ktor.server.auth.jwt.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import me.inassar.demos.common.audience
import me.inassar.demos.common.issuer
import me.inassar.demos.common.secret
import me.inassar.demos.data.model.User
import java.util.*
import kotlin.time.Duration.Companion.minutes

fun Application.configureRouting() {

    routing {
        post("/auth/login") {
            val user = call.receive<User>()
            // check email and password here in database
            val maxHours = (10).times(60).times(60).times(1000)
            val expiresAt = System.currentTimeMillis() + maxHours // 10h in millis
            val claims = mutableMapOf("email" to user.email, "password" to user.password)
            val token = JWT.create()
                .withAudience(audience)
                .withIssuer(issuer)
                .withClaim("data", claims)
                .withExpiresAt(Date(expiresAt))
                .sign(Algorithm.HMAC256(secret))

            val response = hashMapOf(
                "token" to token,
                "email" to user.email,
                "password" to user.password,
                "username" to user.username
            )
            call.respond(response)
        }

        authenticate("auth-jwt") {
            get("/chat/friends-list") {
                val principal = call.principal<JWTPrincipal>()
                val data = principal!!.payload.getClaim("data").asMap()
                val expiresAt = principal.expiresAt?.time?.minus(System.currentTimeMillis())?.minutes

                call.respond(data)
            }
            get("/chat/chat-room") {
                val principal = call.principal<JWTPrincipal>()
                val data = principal!!.payload.getClaim("data").asMap()
                val expiresAt = principal.expiresAt?.time?.minus(System.currentTimeMillis())?.minutes

                call.respond(data)
            }
        }
    }
}
