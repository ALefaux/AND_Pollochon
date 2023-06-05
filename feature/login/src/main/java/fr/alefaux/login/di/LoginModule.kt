package fr.alefaux.login.di

import fr.alefaux.login.LoginViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val loginModule = module {
    viewModel { LoginViewModel(get(), get(), get()) }
}
