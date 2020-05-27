package fr.alefaux.pollochon.di

import fr.alefaux.pollochon.views.splashscreen.SplashscreenViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val splashscreenModule = module {
    viewModel { SplashscreenViewModel() }
}