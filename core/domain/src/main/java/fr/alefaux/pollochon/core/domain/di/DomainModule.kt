package fr.alefaux.pollochon.core.domain.di

import fr.alefaux.pollochon.core.domain.GetUserUseCase
import fr.alefaux.pollochon.core.domain.LogoutUseCase
import fr.alefaux.pollochon.core.domain.SetIsConnectedUseCase
import fr.alefaux.pollochon.core.domain.hello.SayHelloUseCase
import fr.alefaux.pollochon.core.domain.hello.SayHelloUseCaseImpl
import fr.alefaux.pollochon.core.domain.login.CheckUserExistsUseCase
import fr.alefaux.pollochon.core.domain.login.CheckUserExistsUseCaseImpl
import fr.alefaux.pollochon.core.domain.login.RegisterUserNameUseCase
import fr.alefaux.pollochon.core.domain.login.RegisterUserNameUseCaseImpl
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.bind
import org.koin.dsl.module

val domainModule = module {
    factoryOf(::SetIsConnectedUseCase)
    factoryOf(::LogoutUseCase)
    factoryOf(::GetUserUseCase)

    // Hello
    factoryOf(::SayHelloUseCaseImpl) bind SayHelloUseCase::class

    // Login
    factoryOf(::CheckUserExistsUseCaseImpl) bind CheckUserExistsUseCase::class
    factoryOf(::RegisterUserNameUseCaseImpl) bind RegisterUserNameUseCase::class
}
