package fr.alefaux.pollochon.core.data.repository.poll

import fr.alefaux.pollochon.core.model.DataResponse
import fr.alefaux.pollochon.core.model.survey.SurveyType

interface PollRepository {
    suspend fun postSurvey(title: String, type: SurveyType, ownerId: Int): DataResponse<Unit>
}