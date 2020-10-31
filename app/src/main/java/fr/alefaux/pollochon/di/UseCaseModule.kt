package fr.alefaux.pollochon.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import fr.alefaux.pollochon.repositories.PollRepository
import fr.alefaux.pollochon.usecases.ListPollsUseCase

@Module
@InstallIn(ActivityRetainedComponent::class)
object UseCaseModule {

    @Provides
    fun providesListPollsUseCase(pollRepository: PollRepository): ListPollsUseCase {
        return ListPollsUseCase(pollRepository)
    }

}