package fr.alefaux.pollochon.network

import fr.alefaux.pollochon.models.Poll

interface PollNetwork {
    suspend fun getAll(): List<Poll>
}