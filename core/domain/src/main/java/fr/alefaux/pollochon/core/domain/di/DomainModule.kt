package fr.alefaux.pollochon.core.domain.di

import fr.alefaux.pollochon.core.domain.SetIsConnectedUseCase
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module

val domainModule = module {
    factoryOf(::SetIsConnectedUseCase)
}