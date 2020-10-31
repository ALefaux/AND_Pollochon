package fr.alefaux.pollochon.repositories

import fr.alefaux.pollochon.models.Poll
import fr.alefaux.pollochon.network.PollService
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PollRepository @Inject constructor(private val pollService: PollService) {
    suspend fun getAll(): List<Poll> = pollService.getAll()
}