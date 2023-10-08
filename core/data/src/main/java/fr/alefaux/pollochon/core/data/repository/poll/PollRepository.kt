package fr.alefaux.pollochon.core.data.repository.poll

import fr.alefaux.pollochon.core.model.DataResponse
import fr.alefaux.pollochon.core.model.survey.SurveyType
import java.util.Date

interface PollRepository {
    suspend fun postSurvey(
        title: String,
        type: SurveyType,
        ownerId: Int,
        endDate: Date?,
        proposals: List<String>
    ): DataResponse<Unit>
}