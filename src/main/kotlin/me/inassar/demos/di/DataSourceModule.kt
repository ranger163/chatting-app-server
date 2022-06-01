package me.inassar.demos.di

import me.inassar.demos.features.auth.data.local.source.AuthDataSource
import me.inassar.demos.features.auth.data.local.source.AuthDataSourceImpl
import me.inassar.demos.features.chat.data.source.ChatDataSource
import me.inassar.demos.features.chat.data.source.ChatDataSourceImpl
import org.koin.dsl.module

/**
 * Data source module
 * Configuring local data sources dependencies injection
 */
val dataSourceModule = module {
    single<AuthDataSource> {
        AuthDataSourceImpl(get())
    }

    single<ChatDataSource> {
        ChatDataSourceImpl(get())
    }
}