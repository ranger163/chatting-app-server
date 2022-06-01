package me.inassar.demos.plugins

import com.auth0.jwt.JWT
import com.auth0.jwt.algorithms.Algorithm
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.auth.*
import io.ktor.server.auth.jwt.*
import io.ktor.server.response.*
import me.inassar.demos.common.audience
import me.inassar.demos.common.issuer
import me.inassar.demos.common.mRealm
import me.inassar.demos.common.secret
import me.inassar.demos.features.auth.domain.model.login.request.LoginRequestDto
import me.inassar.demos.features.auth.domain.model.signup.request.SignupRequestDto
import java.util.*

fun Application.configureJwt() {

    install(Authentication) {
        jwt("auth-jwt") {
            realm = mRealm
            verifier(
                JWT
                    .require(Algorithm.HMAC256(secret))
                    .withAudience(audience)
                    .withIssuer(issuer)
                    .build()
            )
            validate { credential ->
                if (credential.payload.getClaim("email").asString() != "") {
                    JWTPrincipal(credential.payload)
                } else {
                    null
                }
            }
            challenge { defaultScheme, realm ->
                call.respond(HttpStatusCode.Unauthorized, "Token is not valid or has been expired.")
            }
        }
    }
}

fun generateToken(loginRequestDto: LoginRequestDto? = null, signupRequestDto: SignupRequestDto? = null): String {
    val maxHours = 3_600_000 * 24 // 24h
    val expiresAt = Date(System.currentTimeMillis() + maxHours)
    val claims = when (loginRequestDto) {
        null -> {
            hashMapOf(
                "username" to signupRequestDto?.username,
                "email" to signupRequestDto?.email,
                "password" to signupRequestDto?.password
            )
        }
        else -> {
            hashMapOf("email" to loginRequestDto.email, "password" to loginRequestDto.password)
        }
    }
    return JWT.create()
        .withAudience(audience)
        .withIssuer(issuer)
        .withClaim("data", claims)
        .withExpiresAt(expiresAt)
        .sign(Algorithm.HMAC256(secret))
}