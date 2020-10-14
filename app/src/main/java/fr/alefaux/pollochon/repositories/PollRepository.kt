package fr.alefaux.pollochon.repositories

import fr.alefaux.pollochon.models.Poll

interface PollRepository {
    suspend fun getAll(): List<Poll>
}