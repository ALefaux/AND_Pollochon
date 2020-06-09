package fr.alefaux.pollochon.usecase

import fr.alefaux.pollochon.models.CallingCode
import fr.alefaux.pollochon.repositories.CountriesRepository

class CountriesUseCaseImpl(private val countriesRepository: CountriesRepository): CountriesUseCase {

    override suspend fun getAllCallingCodes(): List<CallingCode> = countriesRepository.getAllCallingCodes()

}