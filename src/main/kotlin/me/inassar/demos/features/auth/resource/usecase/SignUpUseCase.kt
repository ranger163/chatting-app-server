package me.inassar.demos.features.auth.resource.usecase

import me.inassar.demos.common.ERROR_MISSING_EMAIL
import me.inassar.demos.common.ERROR_MISSING_PASSWORD
import me.inassar.demos.common.ERROR_MISSING_USERNAME
import me.inassar.demos.common.ERROR_USER_EXISTS
import me.inassar.demos.features.auth.domain.model.signup.request.SignupRequestDto
import me.inassar.demos.features.auth.domain.mapper.toUser
import me.inassar.demos.features.auth.domain.repository.AuthRepository
import me.inassar.demos.features.auth.resource.AuthResponseState
import me.inassar.demos.plugins.generateToken

class SignUpUseCase(private val repository: AuthRepository) {

    suspend operator fun invoke(request: SignupRequestDto): AuthResponseState {

        if (request.username.isNullOrEmpty()) return AuthResponseState(data = null, error = ERROR_MISSING_USERNAME)
        if (request.email.isNullOrEmpty()) return AuthResponseState(data = null, error = ERROR_MISSING_EMAIL)
        if (request.password.isNullOrEmpty()) return AuthResponseState(data = null, error = ERROR_MISSING_PASSWORD)

        val savedUser = repository.getUser(request.email)?.toUser()

        return if (savedUser == null) {
            val token = generateToken(signupRequestDto = request)
            AuthResponseState(data = repository.insertUser(request = request, token = token), error = null)
        } else {
            AuthResponseState(data = null, error = ERROR_USER_EXISTS)
        }
    }
}