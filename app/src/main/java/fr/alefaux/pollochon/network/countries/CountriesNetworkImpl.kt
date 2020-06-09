package fr.alefaux.pollochon.network.countries

import fr.alefaux.pollochon.models.CallingCode
import fr.alefaux.pollochon.network.callNetwork
import fr.alefaux.pollochon.services.CountriesService

class CountriesNetworkImpl(private val countriesService: CountriesService): CountriesNetwork {

    override suspend fun getAllCallingCodes(): List<CallingCode> {
        return callNetwork {
            countriesService.getAllCallingCodes()
        }
    }

}