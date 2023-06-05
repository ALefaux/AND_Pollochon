package fr.alefaux.pollochon.core.data.di

import fr.alefaux.pollochon.core.data.repository.SettingsRepository
import fr.alefaux.pollochon.core.data.repository.SettingsRepositoryImpl
import fr.alefaux.pollochon.core.data.repository.hello.HelloRepository
import fr.alefaux.pollochon.core.data.repository.hello.HelloRepositoryImpl
import fr.alefaux.pollochon.core.data.repository.home.HomeRepository
import fr.alefaux.pollochon.core.data.repository.home.HomeRepositoryImpl
import fr.alefaux.pollochon.core.data.repository.login.LoginRepository
import fr.alefaux.pollochon.core.data.repository.login.LoginRepositoryImpl
import org.koin.dsl.module

val dataModule = module {
    factory<HomeRepository> { HomeRepositoryImpl(get()) }
    factory<SettingsRepository> { SettingsRepositoryImpl(get()) }
    factory<LoginRepository> { LoginRepositoryImpl(get(), get()) }
    factory<HelloRepository> { HelloRepositoryImpl(get()) }
}
