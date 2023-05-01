package fr.alefaux.pollochon.core.data.di

import fr.alefaux.pollochon.core.data.repository.SettingsRepository
import fr.alefaux.pollochon.core.data.repository.SettingsRepositoryImpl
import fr.alefaux.pollochon.core.data.repository.hello.HelloRepository
import fr.alefaux.pollochon.core.data.repository.hello.HelloRepositoryImpl
import fr.alefaux.pollochon.core.data.repository.login.LoginRepository
import fr.alefaux.pollochon.core.data.repository.login.LoginRepositoryImpl
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.bind
import org.koin.dsl.module

val dataModule = module {
    factoryOf(::SettingsRepositoryImpl) bind SettingsRepository::class
    factoryOf(::LoginRepositoryImpl) bind LoginRepository::class
    factoryOf(::HelloRepositoryImpl) bind HelloRepository::class
}