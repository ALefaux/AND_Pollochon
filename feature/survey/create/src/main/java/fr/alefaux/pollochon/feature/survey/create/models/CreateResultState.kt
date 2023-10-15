package fr.alefaux.pollochon.feature.survey.create.models

sealed interface CreateResultState {
    data object None : CreateResultState
    sealed interface Error : CreateResultState {
        data object BadRequest : Error
        data object UserNotFound : Error
        data class Unknown(val message: String?) : Error
    }

    data object Success : CreateResultState
}
