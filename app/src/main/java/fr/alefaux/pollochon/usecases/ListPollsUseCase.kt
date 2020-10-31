package fr.alefaux.pollochon.usecases

import fr.alefaux.pollochon.models.Poll
import fr.alefaux.pollochon.models.ResultData
import fr.alefaux.pollochon.repositories.PollRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ListPollsUseCase @Inject constructor(private val pollRepository: PollRepository) {
    suspend fun getPolls(): ResultData<List<Poll>> {
        val results = pollRepository.getAll()

        return if(results.isNotEmpty()) {
            ResultData.Success(results)
        } else {
            ResultData.Failed()
        }
    }
}