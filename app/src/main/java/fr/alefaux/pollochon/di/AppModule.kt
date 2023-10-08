package fr.alefaux.pollochon.di

import fr.alefaux.pollochon.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    // ViewModels
    viewModel { HomeViewModel(get(), get(), get()) }
}
