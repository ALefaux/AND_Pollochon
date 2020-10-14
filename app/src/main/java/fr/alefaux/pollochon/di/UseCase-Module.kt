package fr.alefaux.pollochon.di

import fr.alefaux.pollochon.usecases.ListPollsUseCase
import fr.alefaux.pollochon.usecases.ListPollsUseCaseImpl
import org.koin.dsl.module

val useCaseModule = module {
    single { ListPollsUseCaseImpl(get()) as ListPollsUseCase }
}