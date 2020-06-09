package fr.alefaux.pollochon.services

import fr.alefaux.pollochon.models.CallingCode
import retrofit2.Response
import retrofit2.http.GET

interface CountriesService {

    @GET("all")
    suspend fun getAllCallingCodes(): Response<List<CallingCode>>

}