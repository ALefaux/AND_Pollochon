package fr.alefaux.pollochon.core.domain.poll

import fr.alefaux.pollochon.core.model.DataResponse
import fr.alefaux.pollochon.core.model.survey.SurveyType
import kotlinx.coroutines.flow.Flow

fun interface CreatePollUseCase {
    suspend operator fun invoke(
        title: String,
        type: SurveyType,
    ): Flow<DataResponse<Unit>>
}