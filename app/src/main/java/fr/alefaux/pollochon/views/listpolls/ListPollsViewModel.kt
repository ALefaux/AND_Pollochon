package fr.alefaux.pollochon.views.listpolls

import androidx.lifecycle.MutableLiveData
import fr.alefaux.pollochon.BaseViewModel
import fr.alefaux.pollochon.models.Poll
import fr.alefaux.pollochon.usecases.ListPollsUseCase
import org.greenrobot.eventbus.EventBus

class ListPollsViewModel(
    private val listPollsUseCase: ListPollsUseCase,
    errorBus: EventBus
) : BaseViewModel(errorBus) {

    val pollsLiveData = MutableLiveData<List<Poll>>()
    val pollsErrorLiveData = MutableLiveData<Unit>()

    fun getAll() {
        viewModelNetworkCall({
            listPollsUseCase.getPolls()
        }, onSuccess = {
            pollsLiveData.postValue(it)
        }, onError = {
            pollsErrorLiveData.postValue(Unit)
        })
    }

}