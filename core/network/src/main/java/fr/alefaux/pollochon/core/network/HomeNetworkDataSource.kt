package fr.alefaux.pollochon.core.network

import fr.alefaux.pollochon.core.model.DataResponse
import fr.alefaux.pollochon.core.model.survey.HomeSurveys

interface HomeNetworkDataSource {
    suspend fun getHomeData(userId: Int): DataResponse<HomeSurveys>
}
