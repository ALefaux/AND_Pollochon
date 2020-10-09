package fr.alefaux.pollochon.models

open class ApiException(
    val data: ApiExceptionData,
    message: String = ""
) : Exception(message)

//Internet exception
class NoInternetException(message: String) : Exception(message)
class TimeOutException(message: String): Exception(message)

//Error exceptions
class NotFoundException(apiExceptionData: ApiExceptionData) : ApiException(apiExceptionData)
class TokenErrorException(apiExceptionData: ApiExceptionData) : ApiException(apiExceptionData)
class ServerErrorException(apiExceptionData: ApiExceptionData) : ApiException(apiExceptionData)
class ExternalUrlScrapingException(apiExceptionData: ApiExceptionData) : ApiException(apiExceptionData)
class ConflictException(apiExceptionData: ApiExceptionData) : ApiException(apiExceptionData)

//Success exceptions
open class SuccessException(apiExceptionData: ApiExceptionData) : ApiException(apiExceptionData)

class NoContentException(apiExceptionData: ApiExceptionData) : SuccessException(apiExceptionData)
class NoFinishException(apiExceptionData: ApiExceptionData) : SuccessException(apiExceptionData)

data class ApiExceptionData(
    val errorCode: Int,
    val requestType: String,
    val requestUrl: String
)