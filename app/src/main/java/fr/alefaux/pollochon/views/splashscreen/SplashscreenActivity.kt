package fr.alefaux.pollochon.views.splashscreen

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import fr.alefaux.pollochon.R
import fr.alefaux.pollochon.extensions.hide
import fr.alefaux.pollochon.extensions.show
import fr.alefaux.pollochon.views.home.HomeActivity
import kotlinx.android.synthetic.main.activity_splashscreen.*
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import org.koin.android.viewmodel.ext.android.viewModel

class SplashscreenActivity : AppCompatActivity(R.layout.activity_splashscreen) {

    private val splashscreenViewModel: SplashscreenViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        bindViewModel()

        bt_splashscreen_ignore.setOnClickListener {
            splashscreenViewModel.connectAnonymously()
        }
    }

    private fun bindViewModel() {
        splashscreenViewModel.userConnectedLiveData.observe(this, Observer {
            group_splashscreen_login.hide()
            next()
        })
        splashscreenViewModel.userNotConnectedLiveData.observe(this, Observer {
            group_splashscreen_login.show()
        })
        splashscreenViewModel.listen()
    }

    private fun next() {
        lifecycleScope.launch {
            delay(3000)
            val intent = Intent(applicationContext, HomeActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

}
