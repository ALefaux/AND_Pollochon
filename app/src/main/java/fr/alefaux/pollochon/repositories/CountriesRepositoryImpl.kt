package fr.alefaux.pollochon.repositories

import fr.alefaux.pollochon.models.CallingCode
import fr.alefaux.pollochon.network.countries.CountriesNetwork

class CountriesRepositoryImpl(private val countriesNetwork: CountriesNetwork): CountriesRepository {

    override suspend fun getAllCallingCodes(): List<CallingCode> = countriesNetwork.getAllCallingCodes()

}