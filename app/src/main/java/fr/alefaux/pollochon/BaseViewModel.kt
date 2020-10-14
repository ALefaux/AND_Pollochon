package fr.alefaux.pollochon

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import fr.alefaux.pollochon.models.*
import kotlinx.coroutines.launch
import org.greenrobot.eventbus.EventBus
import timber.log.Timber

open class BaseViewModel(private val errorBus: EventBus) : ViewModel() {

    /**
     * Call service method and handles the error cases that are caught
     */
    fun <T> viewModelNetworkCall(
        block: suspend () -> T,
        onSuccess: (T) -> Unit,
        onError: (Exception) -> Unit,
        endPointName: String? = null
    ) =
        viewModelScope.launch {
            try {
                val response = block.invoke()
                onSuccess.invoke(response)
            } catch (e: SuccessException) {
                onError.invoke(e)
            } catch (e: ExternalUrlScrapingException) {
                onError.invoke(e)
            } catch (e: ConflictException) {
                onError.invoke(e)
            } catch (e: TimeOutException) {
                onError.invoke(e)
                errorBus.post(Pair(ErrorType.ErrorTimeOut, endPointName))
            } catch (e: NoInternetException) {
                errorBus.post(Pair(ErrorType.ErrorNotInternet, e.message))
            } catch (e: TokenErrorException) {
                errorBus.post(Pair(ErrorType.ErrorToken, ""))
            } catch (e: ApiException) {
                Timber.e(e, "${e.data.errorCode} - ${e.data.requestType} - ${e.data.requestUrl}")
                errorBus.post(Pair(ErrorType.ErrorGeneric, ""))
                onError.invoke(e)
            } catch (e: Exception) {
                Timber.e(e)
                onError.invoke(e)
            }
        }

    sealed class ErrorType {
        object ErrorMessage : ErrorType()
        object ErrorToken : ErrorType()
        object ErrorGeneric : ErrorType()
        object ErrorTimeOut : ErrorType()
        object ErrorNotInternet : ErrorType()
    }
}