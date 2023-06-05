package fr.alefaux.pollochon.core.domain.home

import fr.alefaux.pollochon.core.data.repository.SettingsRepository
import fr.alefaux.pollochon.core.data.repository.home.HomeRepository
import fr.alefaux.pollochon.core.model.DataResponse
import fr.alefaux.pollochon.core.model.survey.HomeSurveys
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.flow.map

class GetHomeSurveysUseCaseImpl(
    private val settingsRepository: SettingsRepository,
    private val homeRepository: HomeRepository
) : GetHomeSurveysUseCase {
    override suspend fun invoke(): Flow<DataResponse<HomeSurveys>> {
        val userId = settingsRepository.getUserId().firstOrNull()
        return settingsRepository.getUserId().map { userId ->
            homeRepository.getHomeSurveys(userId)
        }
    }
}
