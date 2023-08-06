package fr.alefaux.pollochon.core.domain.di

import fr.alefaux.pollochon.core.domain.GetUserUseCase
import fr.alefaux.pollochon.core.domain.LogoutUseCase
import fr.alefaux.pollochon.core.domain.SetIsConnectedUseCase
import fr.alefaux.pollochon.core.domain.hello.SayHelloUseCase
import fr.alefaux.pollochon.core.domain.hello.SayHelloUseCaseImpl
import fr.alefaux.pollochon.core.domain.home.GetHomeSurveysUseCase
import fr.alefaux.pollochon.core.domain.home.GetHomeSurveysUseCaseImpl
import fr.alefaux.pollochon.core.domain.login.CheckUserExistsUseCase
import fr.alefaux.pollochon.core.domain.login.CheckUserExistsUseCaseImpl
import fr.alefaux.pollochon.core.domain.login.RegisterUserNameUseCase
import fr.alefaux.pollochon.core.domain.login.RegisterUserNameUseCaseImpl
import fr.alefaux.pollochon.core.domain.poll.CreatePollUseCase
import fr.alefaux.pollochon.core.domain.poll.CreatePollUseCaseImpl
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module

val domainModule = module {
    factoryOf(::SetIsConnectedUseCase)
    factoryOf(::LogoutUseCase)
    factoryOf(::GetUserUseCase)

    // Hello
    factory<SayHelloUseCase> { SayHelloUseCaseImpl(get()) }

    // Login
    factory<CheckUserExistsUseCase> { CheckUserExistsUseCaseImpl(get()) }
    factory<RegisterUserNameUseCase> { RegisterUserNameUseCaseImpl(get(), get()) }

    // Home
    factory<GetHomeSurveysUseCase> { GetHomeSurveysUseCaseImpl(get(), get()) }

    // Poll
    factory<CreatePollUseCase> { CreatePollUseCaseImpl(get(), get()) }
}
