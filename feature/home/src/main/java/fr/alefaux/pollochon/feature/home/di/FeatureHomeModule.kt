package fr.alefaux.pollochon.feature.home.di

import fr.alefaux.pollochon.core.domain.home.GetHomeSurveysUseCase
import fr.alefaux.pollochon.core.domain.home.GetHomeSurveysUseCaseImpl
import fr.alefaux.pollochon.feature.home.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val featureHomeModule = module {
    // ViewModels
    viewModel { HomeViewModel(get()) }
}
