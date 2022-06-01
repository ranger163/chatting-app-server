package me.inassar.demos.features.auth.resource

import me.inassar.demos.features.auth.resource.data.User

/**
 * Auth response state
 * This data class holds data states in case of success
 * or failure to be sent as final response through endpoints call.
 * @property data
 * @property error
 * @constructor Create empty Auth response state
 */
@kotlinx.serialization.Serializable
data class AuthResponseState(
    val data: User? = null,
    val error: HashMap<String, String>? = null
)
