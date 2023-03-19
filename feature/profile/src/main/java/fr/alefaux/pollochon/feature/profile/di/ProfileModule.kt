package fr.alefaux.pollochon.feature.profile.di

import fr.alefaux.pollochon.feature.profile.ProfileViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

val profileModule = module {
    viewModelOf(::ProfileViewModel)
}
