package fr.alefaux.pollochon.usecases

import fr.alefaux.pollochon.models.Poll

interface ListPollsUseCase {
    suspend fun getPolls(): List<Poll>
}