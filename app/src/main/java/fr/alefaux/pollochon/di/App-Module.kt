package fr.alefaux.pollochon.di

import fr.alefaux.pollochon.views.listpolls.ListPollsViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    viewModel { ListPollsViewModel(get(), get()) }
}