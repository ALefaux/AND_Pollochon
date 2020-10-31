package fr.alefaux.pollochon.views.home

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.platform.setContent
import dagger.hilt.android.AndroidEntryPoint
import fr.alefaux.pollochon.theming.PollochonTheme
import fr.alefaux.pollochon.views.listpolls.ListPolls
import fr.alefaux.pollochon.views.listpolls.ListPollsViewModel

@AndroidEntryPoint
class HomeActivity : AppCompatActivity() {

    private val listPollsViewModel: ListPollsViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            PollochonTheme {
                Surface(color = MaterialTheme.colors.background) {
                    listPollsViewModel.getAll()
                    ListPolls(listPollsViewModel)
                }
            }
        }
    }

}
