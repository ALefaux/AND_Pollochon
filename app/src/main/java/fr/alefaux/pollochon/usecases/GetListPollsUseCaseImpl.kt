package fr.alefaux.pollochon.usecases

import fr.alefaux.pollochon.models.Poll
import fr.alefaux.pollochon.models.ResultData
import fr.alefaux.pollochon.repositories.PollRepositoryImpl

class GetListPollsUseCaseImpl(private val pollRepository: PollRepositoryImpl): PollsUseCase.GetListPolls {
    override suspend fun getPolls(): List<Poll> {
        return pollRepository.getAll()
    }
}