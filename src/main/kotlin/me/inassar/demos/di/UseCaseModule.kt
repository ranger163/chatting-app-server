package me.inassar.demos.di

import me.inassar.demos.features.auth.resource.usecase.LoginUseCase
import me.inassar.demos.features.auth.resource.usecase.SignUpUseCase
import me.inassar.demos.features.chat.resource.usecase.ConnectToSocketUseCase
import me.inassar.demos.features.chat.resource.usecase.FriendListUseCase
import me.inassar.demos.features.chat.resource.usecase.GetHistoryMessagesUseCase
import org.koin.dsl.module

/**
 * Use case module
 * Configuring useCases dependency injection
 */
val useCaseModule = module {
    single { SignUpUseCase(get()) }
    single { LoginUseCase(get()) }
    single { FriendListUseCase(get()) }
    single { ConnectToSocketUseCase(get()) }
    single { GetHistoryMessagesUseCase(get(), get()) }
}