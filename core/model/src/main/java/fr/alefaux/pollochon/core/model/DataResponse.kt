package fr.alefaux.pollochon.core.model

sealed class DataResponse<out T : Any> {
    object Success : DataResponse<Nothing>()
    object Created : DataResponse<Nothing>()
    data class Found<out T : Any>(val data: T) : DataResponse<T>()
    object BadRequest : DataResponse<Nothing>()
    object Conflict : DataResponse<Nothing>()
    object NotFound : DataResponse<Nothing>()
    object Error : DataResponse<Nothing>()
    object Unknown : DataResponse<Nothing>()

    fun isSuccess(): Boolean {
        return this is Success || this is Created || this is Found
    }
}
