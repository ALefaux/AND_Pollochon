package fr.alefaux.pollochon.views.splashscreen

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth

class SplashscreenViewModel: ViewModel() {

    val userNotConnectedLiveData = MutableLiveData<Unit>()
    val userConnectedLiveData = MutableLiveData<Unit>()

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

}