package fr.alefaux.pollochon.views.listpolls

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import dagger.hilt.android.scopes.ActivityScoped
import fr.alefaux.pollochon.models.Poll
import fr.alefaux.pollochon.models.ResultData
import fr.alefaux.pollochon.usecases.ListPollsUseCase
import kotlinx.coroutines.Dispatchers
import java.lang.Exception

@ActivityScoped
class ListPollsViewModel @ViewModelInject constructor(
    private val listPollsUseCase: ListPollsUseCase
) : ViewModel() {

    private var _pollsLiveData: LiveData<ResultData<List<Poll>>> = MutableLiveData()
    val pollsLiveData: LiveData<ResultData<List<Poll>>> get() = _pollsLiveData

    fun getAll() {
        _pollsLiveData = liveData(Dispatchers.IO) {
            emit(ResultData.Loading())

            try {
                emit(listPollsUseCase.getPolls())
            } catch (e: Exception) {
                e.printStackTrace()
                emit(ResultData.Exception())
            }
        }
    }

}