package fr.alefaux.pollochon.core.network

import fr.alefaux.pollochon.core.model.DataResponse
import fr.alefaux.pollochon.core.network.model.CreateSurveyApi

interface PollNetworkDataSource {
    suspend fun postSurvey(createSurvey: CreateSurveyApi): DataResponse<Unit>
}
