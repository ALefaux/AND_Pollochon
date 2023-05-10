package fr.alefaux.pollochon.core.domain.home

import fr.alefaux.pollochon.core.data.repository.SettingsRepository
import fr.alefaux.pollochon.core.data.repository.home.HomeRepository
import fr.alefaux.pollochon.core.model.DataResponse
import fr.alefaux.pollochon.core.model.survey.HomeSurveys
import kotlinx.coroutines.flow.last

class GetHomeSurveysUseCaseImpl(
    private val settingsRepository: SettingsRepository,
    private val homeRepository: HomeRepository
) : GetHomeSurveysUseCase {
    override suspend fun invoke(): DataResponse<HomeSurveys> {
        val userId: Int = settingsRepository.getUserId().last()
        return homeRepository.getHomeSurveys(userId)
    }
}
