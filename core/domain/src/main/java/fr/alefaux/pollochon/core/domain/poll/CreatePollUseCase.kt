package fr.alefaux.pollochon.core.domain.poll

import fr.alefaux.pollochon.core.model.DataResponse
import fr.alefaux.pollochon.core.model.survey.SurveyType
import kotlinx.coroutines.flow.Flow
import java.util.Date

fun interface CreatePollUseCase {
    suspend operator fun invoke(
        title: String,
        type: SurveyType,
        endDate: Date?,
        proposals: List<String>
    ): Flow<DataResponse<Unit>>
}