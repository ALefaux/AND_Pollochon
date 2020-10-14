package fr.alefaux.pollochon.di

import fr.alefaux.pollochon.network.PollNetwork
import fr.alefaux.pollochon.network.PollNetworkImpl
import org.koin.dsl.module

val networkModule = module {
    single { PollNetworkImpl(get()) as PollNetwork }
}