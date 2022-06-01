package me.inassar.demos.di

import me.inassar.demos.features.auth.resource.usecase.LoginUseCase
import me.inassar.demos.features.auth.resource.usecase.SignUpUseCase
import org.koin.dsl.module

/**
 * Use case module
 * Configuring useCases dependency injection
 */
val useCaseModule = module {
    single { SignUpUseCase(get()) }
    single { LoginUseCase(get()) }
}