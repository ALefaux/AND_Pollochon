package fr.alefaux.pollochon.core.data.repository.home

import fr.alefaux.pollochon.core.model.DataResponse
import fr.alefaux.pollochon.core.model.survey.HomeSurveys
import fr.alefaux.pollochon.core.network.retrofit.HomeNetwork

class HomeRepositoryImpl(
    private val homeNetwork: HomeNetwork,
) : HomeRepository {
    override suspend fun getHomeSurveys(userId: Int): DataResponse<HomeSurveys> {
        return homeNetwork.getHomeData(userId)
    }
}
