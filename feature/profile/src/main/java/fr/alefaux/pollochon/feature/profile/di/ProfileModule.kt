package fr.alefaux.pollochon.feature.profile.di

import fr.alefaux.pollochon.feature.profile.screen.profile.ProfileViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val profileModule = module {
    viewModel {
        ProfileViewModel(
            logoutUseCase = get(),
            getUserUseCase = get(),
            getFriendsUseCase = get()
        )
    }
}
