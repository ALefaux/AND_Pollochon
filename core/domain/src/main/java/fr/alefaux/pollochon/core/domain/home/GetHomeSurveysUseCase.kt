package fr.alefaux.pollochon.core.domain.home

import fr.alefaux.pollochon.core.model.DataResponse
import fr.alefaux.pollochon.core.model.survey.HomeSurveys

fun interface GetHomeSurveysUseCase {
    suspend operator fun invoke(): DataResponse<HomeSurveys>
}
