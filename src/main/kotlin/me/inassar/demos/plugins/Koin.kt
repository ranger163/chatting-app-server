package me.inassar.demos.plugins

import io.ktor.server.application.*
import me.inassar.demos.di.appModule
import me.inassar.demos.di.dataSourceModule
import me.inassar.demos.di.repositoryModule
import me.inassar.demos.di.useCaseModule
import org.koin.core.context.startKoin

fun Application.configureKoin() {
    startKoin {
        modules(appModule, dataSourceModule, repositoryModule, useCaseModule)
    }
}