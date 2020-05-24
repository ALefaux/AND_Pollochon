package fr.alefaux.pollochon.views.splashscreen

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import fr.alefaux.pollochon.R
import fr.alefaux.pollochon.views.home.HomeActivity
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SplashscreenActivity : AppCompatActivity(R.layout.activity_splashscreen) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        lifecycleScope.launch {
            delay(3000)
            val intent = Intent(applicationContext, HomeActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

}
