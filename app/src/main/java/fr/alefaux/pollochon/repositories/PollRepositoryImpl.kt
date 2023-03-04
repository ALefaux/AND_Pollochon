package fr.alefaux.pollochon.repositories

import fr.alefaux.pollochon.models.Poll
import fr.alefaux.pollochon.network.PollService

class PollRepositoryImpl(private val pollService: PollService): PollRepository {
    override suspend fun getAll(): List<Poll> = pollService.getAll()
}