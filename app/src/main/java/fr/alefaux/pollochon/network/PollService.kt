package fr.alefaux.pollochon.network

import fr.alefaux.pollochon.models.Poll
import retrofit2.http.GET

interface PollService {

    @GET(PREFIX)
    suspend fun getAll(): List<Poll>

    companion object {
        private const val PREFIX = "polls"
    }

}