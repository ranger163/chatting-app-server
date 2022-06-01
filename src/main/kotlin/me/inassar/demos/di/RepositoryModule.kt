package me.inassar.demos.di

import me.inassar.demos.features.auth.domain.repository.AuthRepository
import me.inassar.demos.features.auth.domain.repository.AuthRepositoryImpl
import me.inassar.demos.features.chat.domain.repository.ChatRepository
import me.inassar.demos.features.chat.domain.repository.ChatRepositoryImpl
import org.koin.dsl.module

/**
 * Repository module
 * Configuring repositories dependency injection
 */
val repositoryModule = module {
    single<AuthRepository> {
        AuthRepositoryImpl(get())
    }

    single<ChatRepository> {
        ChatRepositoryImpl(get())
    }
}