package fr.alefaux.pollochon.di

import fr.alefaux.pollochon.HomeViewModel
import fr.alefaux.pollochon.repositories.PollRepository
import fr.alefaux.pollochon.repositories.PollRepositoryImpl
import fr.alefaux.pollochon.usecases.GetListPollsUseCaseImpl
import fr.alefaux.pollochon.usecases.PollsUseCase
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.bind
import org.koin.dsl.module

val appModule = module {
    // Repositories
    factoryOf(::PollRepositoryImpl) bind PollRepository::class

    // UseCases
    factoryOf(::GetListPollsUseCaseImpl) bind PollsUseCase.GetListPolls::class

    // ViewModels
    viewModelOf(::HomeViewModel)
}
