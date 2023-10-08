package fr.alefaux.pollochon.core.model

sealed class DataResponse<out T : Any> {
    data class Success<out T : Any>(val data: T) : DataResponse<T>()
    data object Created : DataResponse<Nothing>()
    data class Found<out T : Any>(val data: T) : DataResponse<T>()
    data class BadRequest(val errorResponse: ErrorResponse?) : DataResponse<Nothing>()
    data object Conflict : DataResponse<Nothing>()
    data object NotFound : DataResponse<Nothing>()
    data object Error : DataResponse<Nothing>()
    data object Unknown : DataResponse<Nothing>()

    fun isSuccess(): Boolean {
        return this is Success || this is Created || this is Found
    }
}
