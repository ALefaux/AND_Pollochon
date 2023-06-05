package fr.alefaux.pollochon.core.data.repository.home

import fr.alefaux.pollochon.core.model.DataResponse
import fr.alefaux.pollochon.core.model.survey.HomeSurveys
import fr.alefaux.pollochon.core.network.HomeNetworkDataSource

class HomeRepositoryImpl(
    private val homeNetwork: HomeNetworkDataSource,
) : HomeRepository {
    override suspend fun getHomeSurveys(userId: Int): DataResponse<HomeSurveys> {
        return homeNetwork.getHomeData(userId)
    }
}
