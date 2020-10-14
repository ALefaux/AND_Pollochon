package fr.alefaux.pollochon.network

import fr.alefaux.pollochon.models.Poll
import fr.alefaux.pollochon.network.utils.callNetwork
import fr.alefaux.pollochon.services.PollService

class PollNetworkImpl(private val pollService: PollService) : PollNetwork {
    override suspend fun getAll(): List<Poll> = callNetwork {
        pollService.getAll()
    }
}