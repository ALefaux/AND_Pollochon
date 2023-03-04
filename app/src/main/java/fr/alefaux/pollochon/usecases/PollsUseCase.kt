package fr.alefaux.pollochon.usecases

import fr.alefaux.pollochon.models.Poll
import fr.alefaux.pollochon.models.ResultData

interface PollsUseCase {
    interface GetListPolls {
        suspend fun getPolls(): List<Poll>
    }
}