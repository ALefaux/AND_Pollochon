package fr.alefaux.pollochon.feature.survey.create.models

import fr.alefaux.pollochon.core.model.survey.SurveyType
import java.util.Date

data class CreateSurveyUi(
    val title: String,
    val type: SurveyType?,
    val endDate: Date?
)
