package fr.alefaux.pollochon.core.data.repository.poll

import fr.alefaux.pollochon.core.model.DataResponse
import fr.alefaux.pollochon.core.model.survey.SurveyType
import fr.alefaux.pollochon.core.network.PollNetworkDataSource
import fr.alefaux.pollochon.core.network.model.CreateSurveyApi

class PollRepositoryImpl(
    private val pollNetwork: PollNetworkDataSource,
): PollRepository {
    override suspend fun postSurvey(title: String, type: SurveyType, ownerId: Int): DataResponse<Unit> {
        return pollNetwork.postSurvey(CreateSurveyApi(title, type, ownerId))
    }
}