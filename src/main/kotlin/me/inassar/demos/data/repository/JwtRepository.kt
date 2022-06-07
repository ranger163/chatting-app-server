package me.inassar.demos.data.repository

import com.auth0.jwt.interfaces.Claim

interface JwtRepository {
    suspend fun setPayload(claims: Claim)
    fun getEmailPayload(): String
}