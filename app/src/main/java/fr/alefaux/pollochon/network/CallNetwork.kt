package fr.alefaux.pollochon.network

import fr.alefaux.pollochon.models.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response
import timber.log.Timber
import java.net.ConnectException
import java.net.SocketTimeoutException
import java.net.UnknownHostException

suspend fun <T : Any> callNetwork(block: suspend () -> Response<T>): T =
    withContext(Dispatchers.IO) {
        try {
            val callResponse = block.invoke()
            val exceptionData = ApiExceptionData(
                callResponse.code(),
                callResponse.raw().request.method,
                callResponse.raw().request.url.toString()
            )
            when (callResponse.code()) {
                200, 201, 202 -> return@withContext callResponse.body()!!
                204 -> throw NoContentException(exceptionData)
                401 -> throw TokenErrorException(exceptionData)
                404 -> throw NotFoundException(exceptionData)
                409 -> throw ConflictException(exceptionData)
                500 -> throw ServerErrorException(exceptionData)
                else -> throw ApiException(exceptionData)
            }
        } catch (e: SocketTimeoutException) {
            Timber.e(e, "[ALE] Time out for $block")
            throw TimeOutException("Time out")
        } catch (e: UnknownHostException) {
            throw NoInternetException("No internet")
        } catch (e: ConnectException) {
            throw NoInternetException("No internet")
        }
    }