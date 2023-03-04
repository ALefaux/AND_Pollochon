package fr.alefaux.pollochon.views.splashscreen

import android.content.Intent
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.lifecycle.lifecycleScope
import fr.alefaux.pollochon.R
import fr.alefaux.pollochon.theming.PollochonTheme
import fr.alefaux.pollochon.theming.splashscreenBackgroundColor
import fr.alefaux.pollochon.views.home.HomeActivity
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SplashscreenActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            SplashscreenContent()
        }

        lifecycleScope.launch {
            delay(3000)
            val intent = Intent(applicationContext, HomeActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

}

@Composable
fun SplashscreenContent() {
    PollochonTheme {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .then(
                    Modifier.background(splashscreenBackgroundColor)
                )
        ) {
            Image(painterResource(R.drawable.ic_logo), contentDescription = null)
            Text(
                stringResource(id = R.string.app_name),
                style = TextStyle(
                    color = Color.White,
                    fontSize = 30.sp,
                    fontWeight = FontWeight.Bold
                )
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SplashscreenContent_Preview() {
    SplashscreenContent()
}
