package fr.alefaux.pollochon.views.listpolls

import androidx.compose.foundation.Text
import androidx.compose.foundation.layout.ConstraintLayout
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumnFor
import androidx.compose.material.LinearProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import fr.alefaux.pollochon.models.ResultData

@Composable
fun ListPolls(listPollsViewModel: ListPollsViewModel) {
    val dataState = listPollsViewModel.pollsLiveData.observeAsState()

    ConstraintLayout {
        when (val resultData = dataState.value) {
            is ResultData.Loading -> {
                LinearProgressIndicator(
                    modifier = Modifier.fillMaxWidth()
                )
            }
            is ResultData.Success -> {
                resultData.data?.let { polls ->
                    LazyColumnFor(items = polls) {
                        ListPollsRow(poll = it)
                    }
                }
            }
            is ResultData.Failed -> {
                Text(text = "Pas de poll participé.")
            }
            is ResultData.Exception -> {
                Text(text = "Something went wrong. Please try again!")
            }
        }
    }
}