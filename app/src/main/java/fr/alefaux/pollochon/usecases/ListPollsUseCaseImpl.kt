package fr.alefaux.pollochon.usecases

import fr.alefaux.pollochon.models.Poll
import fr.alefaux.pollochon.repositories.PollRepository

class ListPollsUseCaseImpl(private val pollRepository: PollRepository): ListPollsUseCase {
    override suspend fun getPolls(): List<Poll> = pollRepository.getAll()
}