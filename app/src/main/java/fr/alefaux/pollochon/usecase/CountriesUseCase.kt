package fr.alefaux.pollochon.usecase

import fr.alefaux.pollochon.models.CallingCode

interface CountriesUseCase {

    suspend fun getAllCallingCodes(): List<CallingCode>

}