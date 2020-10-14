package fr.alefaux.pollochon.repositories

import fr.alefaux.pollochon.models.Poll
import fr.alefaux.pollochon.network.PollNetwork

class PollRepositoryImpl(private val pollNetwork: PollNetwork): PollRepository {
    override suspend fun getAll(): List<Poll> = pollNetwork.getAll()
}