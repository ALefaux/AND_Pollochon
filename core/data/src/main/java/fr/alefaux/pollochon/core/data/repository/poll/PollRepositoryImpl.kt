package fr.alefaux.pollochon.core.data.repository.poll

import fr.alefaux.pollochon.core.model.DataResponse
import fr.alefaux.pollochon.core.model.extensions.toIso
import fr.alefaux.pollochon.core.model.survey.SurveyType
import fr.alefaux.pollochon.core.network.PollNetworkDataSource
import fr.alefaux.pollochon.core.network.model.CreateSurveyApi
import java.util.Date

class PollRepositoryImpl(
    private val pollNetwork: PollNetworkDataSource,
) : PollRepository {
    override suspend fun postSurvey(
        title: String,
        type: SurveyType,
        ownerId: Int,
        endDate: Date?,
        proposals: List<String>
    ): DataResponse<Unit> {
        val createSurvey = CreateSurveyApi(title, type, ownerId, endDate?.toIso(), proposals)
        return pollNetwork.postSurvey(createSurvey)
    }
}