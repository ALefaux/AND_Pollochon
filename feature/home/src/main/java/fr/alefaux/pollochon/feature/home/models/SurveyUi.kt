package fr.alefaux.pollochon.feature.home.models

data class SurveyUi(
    val id: Int,
    val title: String,
    val numberShared: String,
    val numberAnswered: String,
    val userId: Int,
    val userName: String,
    val userImageUrl: String?,
)
