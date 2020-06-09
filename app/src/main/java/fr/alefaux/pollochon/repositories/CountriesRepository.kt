package fr.alefaux.pollochon.repositories

import fr.alefaux.pollochon.models.CallingCode

interface CountriesRepository {

    suspend fun getAllCallingCodes(): List<CallingCode>

}