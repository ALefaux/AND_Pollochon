package fr.alefaux.pollochon.di

import org.greenrobot.eventbus.EventBus
import org.koin.dsl.module

val busModule = module {
    single { EventBus.builder().build() }
}