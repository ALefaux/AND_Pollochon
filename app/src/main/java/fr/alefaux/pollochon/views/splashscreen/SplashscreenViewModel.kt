package fr.alefaux.pollochon.views.splashscreen

import androidx.lifecycle.MutableLiveData
import com.google.android.gms.tasks.TaskExecutors
import com.google.firebase.FirebaseException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.PhoneAuthCredential
import com.google.firebase.auth.PhoneAuthProvider
import fr.alefaux.pollochon.models.CallingCode
import fr.alefaux.pollochon.usecase.CountriesUseCase
import fr.alefaux.pollochon.views.BaseViewModel
import org.greenrobot.eventbus.EventBus
import timber.log.Timber
import java.util.*
import java.util.concurrent.TimeUnit

class SplashscreenViewModel(private val countriesUseCase: CountriesUseCase, errorBus: EventBus) : BaseViewModel(errorBus) {

    val userNotConnectedLiveData = MutableLiveData<Unit>()
    val userConnectedLiveData = MutableLiveData<Unit>()
    val callingCodesLiveData = MutableLiveData<List<CallingCode>>()

    private val auth = FirebaseAuth.getInstance()

    fun listen() {
        auth.addAuthStateListener { firebaseAuth ->
            if (firebaseAuth.currentUser == null) {
                userNotConnectedLiveData.postValue(Unit)
            } else {
                userConnectedLiveData.postValue(Unit)
            }
        }
    }

    fun connectAnonymously() {
        auth.signInAnonymously()
    }

    fun connectWithPhone(phoneNumber: String) {
        PhoneAuthProvider.getInstance()
            .verifyPhoneNumber(phoneNumber, 60, TimeUnit.SECONDS, TaskExecutors.MAIN_THREAD, object : PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
                override fun onVerificationCompleted(p0: PhoneAuthCredential) {
                    Timber.d("[ALE] onVerificationCompleted")
                }

                override fun onVerificationFailed(p0: FirebaseException) {
                    Timber.e(p0, "[ALE] onVerificationFailed")
                }

                override fun onCodeAutoRetrievalTimeOut(p0: String) {
                    super.onCodeAutoRetrievalTimeOut(p0)

                    Timber.d("[ALE] onCodeAutoRetrievalTimeOut")
                }

                override fun onCodeSent(p0: String, p1: PhoneAuthProvider.ForceResendingToken) {
                    super.onCodeSent(p0, p1)

                    Timber.d("[ALE] onCodeSent")
                }

            })
    }

    fun getAllCallingCodes() {
        viewModelNetworkCall({
            countriesUseCase.getAllCallingCodes()
        }, onSuccess = { callingCodesFetched ->
            val countryCode = Locale.getDefault().country
            val frenchCallingCode = callingCodesFetched.find { it.countryCode == countryCode }
            val callingCodes = callingCodesFetched.toMutableList().apply {
                frenchCallingCode?.let {
                    remove(frenchCallingCode)
                    add(0, frenchCallingCode)
                }
            }
            callingCodesLiveData.postValue(callingCodes)
        }, onError = {
            Timber.d(it, "Error during fetch calling codes")
        })
    }

}