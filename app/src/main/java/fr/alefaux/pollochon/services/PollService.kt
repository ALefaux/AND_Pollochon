package fr.alefaux.pollochon.services

import fr.alefaux.pollochon.models.Poll
import retrofit2.Response
import retrofit2.http.GET

interface PollService {

    @GET(PREFIX)
    suspend fun getAll(): Response<List<Poll>>

    companion object {
        private const val PREFIX = "polls"
    }

}