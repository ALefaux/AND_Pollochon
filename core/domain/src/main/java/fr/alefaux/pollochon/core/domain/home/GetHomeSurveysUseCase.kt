package fr.alefaux.pollochon.core.domain.home

import fr.alefaux.pollochon.core.model.DataResponse
import fr.alefaux.pollochon.core.model.survey.HomeSurveys
import kotlinx.coroutines.flow.Flow

fun interface GetHomeSurveysUseCase {
    suspend operator fun invoke(): Flow<DataResponse<HomeSurveys>>
}
