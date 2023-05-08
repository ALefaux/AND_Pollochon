package fr.alefaux.pollochon.core.network

import fr.alefaux.pollochon.core.model.DataResponse
import fr.alefaux.pollochon.core.model.survey.HomeSurvey

interface HomeNetworkDataSource {
    suspend fun getHomeData(userId: String): DataResponse<HomeSurvey>
}
