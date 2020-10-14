package fr.alefaux.pollochon.di

import fr.alefaux.pollochon.SharedPref
import fr.alefaux.pollochon.SharedPrefImpl
import fr.alefaux.pollochon.repositories.PollRepository
import fr.alefaux.pollochon.repositories.PollRepositoryImpl
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val repositoryModule = module {
    single { PollRepositoryImpl(get()) as PollRepository }

    single { SharedPrefImpl(androidContext()) as SharedPref }
}