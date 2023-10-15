package fr.alefaux.pollochon.feature.home.mapper

import fr.alefaux.pollochon.core.model.survey.Survey
import fr.alefaux.pollochon.feature.home.models.SurveyUi

fun Survey.toUi(): SurveyUi =
    SurveyUi(
        id = id,
        title = title,
        numberShared = invitations.size.toString(),
        numberAnswered = "0/${invitations.size}",
        userId = owner.id,
        userName = owner.userName,
        userImageUrl = owner.userImageUrl,
    )