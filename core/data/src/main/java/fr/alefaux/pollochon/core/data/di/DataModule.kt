package fr.alefaux.pollochon.core.data.di

import fr.alefaux.pollochon.core.data.repository.SettingsRepository
import fr.alefaux.pollochon.core.data.repository.SettingsRepositoryImpl
import fr.alefaux.pollochon.core.data.repository.hello.HelloRepository
import fr.alefaux.pollochon.core.data.repository.hello.HelloRepositoryImpl
import fr.alefaux.pollochon.core.data.repository.home.HomeRepository
import fr.alefaux.pollochon.core.data.repository.home.HomeRepositoryImpl
import fr.alefaux.pollochon.core.data.repository.login.LoginRepository
import fr.alefaux.pollochon.core.data.repository.login.LoginRepositoryImpl
import fr.alefaux.pollochon.core.data.repository.poll.PollRepository
import fr.alefaux.pollochon.core.data.repository.poll.PollRepositoryImpl
import org.koin.dsl.module

val dataModule = module {
    // Home
    factory<HomeRepository> { HomeRepositoryImpl(get()) }

    // Settings
    factory<SettingsRepository> { SettingsRepositoryImpl(get()) }

    // Login
    factory<LoginRepository> { LoginRepositoryImpl(get(), get()) }

    // Hello
    factory<HelloRepository> { HelloRepositoryImpl(get()) }

    // Poll
    factory<PollRepository> { PollRepositoryImpl(get()) }
}
