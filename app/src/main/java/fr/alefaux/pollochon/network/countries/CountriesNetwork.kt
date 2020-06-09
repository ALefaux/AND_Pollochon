package fr.alefaux.pollochon.network.countries

import fr.alefaux.pollochon.models.CallingCode

interface CountriesNetwork {
    suspend fun getAllCallingCodes(): List<CallingCode>
}