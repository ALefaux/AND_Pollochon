package fr.alefaux.pollochon.feature.survey.create.models

import fr.alefaux.pollochon.core.model.survey.SurveyType

data class ChoiceType(
    val icon: String,
    val title: String,
    val type: SurveyType,
)