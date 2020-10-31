package fr.alefaux.pollochon.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import fr.alefaux.pollochon.network.PollService
import fr.alefaux.pollochon.repositories.PollRepository

@Module
@InstallIn(ActivityRetainedComponent::class)
object RepositoryModule {

    @Provides
    fun providesPollRepository(pollService: PollService): PollRepository {
        return PollRepository(pollService)
    }

}