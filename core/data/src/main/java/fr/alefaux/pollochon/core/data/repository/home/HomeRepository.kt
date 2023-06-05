package fr.alefaux.pollochon.core.data.repository.home

import fr.alefaux.pollochon.core.model.DataResponse
import fr.alefaux.pollochon.core.model.survey.HomeSurveys

interface HomeRepository {
    suspend fun getHomeSurveys(userId: Int): DataResponse<HomeSurveys>
}
