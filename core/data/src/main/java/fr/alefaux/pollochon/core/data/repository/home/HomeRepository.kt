package fr.alefaux.pollochon.core.data.repository.home

import fr.alefaux.pollochon.core.model.DataResponse
import fr.alefaux.pollochon.core.model.survey.HomeSurvey

interface HomeRepository {
    suspend fun getHomeSurveys(userId: Int): DataResponse<HomeSurvey>
}
