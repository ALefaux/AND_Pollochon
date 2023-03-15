package fr.alefaux.pollochon.core.data.di

import fr.alefaux.pollochon.core.data.repository.SettingsRepository
import fr.alefaux.pollochon.core.data.repository.SettingsRepositoryImpl
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.bind
import org.koin.dsl.module

val dataModule = module {
    factoryOf(::SettingsRepositoryImpl) bind SettingsRepository::class
}