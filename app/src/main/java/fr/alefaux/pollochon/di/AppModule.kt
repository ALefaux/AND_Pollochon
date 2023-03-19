package fr.alefaux.pollochon.di

import fr.alefaux.login.LoginViewModel
import fr.alefaux.pollochon.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

val appModule = module {
    // ViewModels
    viewModelOf(::HomeViewModel)
    viewModelOf(::LoginViewModel)
}
