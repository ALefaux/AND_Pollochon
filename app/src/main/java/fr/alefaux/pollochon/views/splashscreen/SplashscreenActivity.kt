package fr.alefaux.pollochon.views.splashscreen

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.Text
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.ConstraintLayout
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.setContent
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.lifecycleScope
import androidx.ui.tooling.preview.Preview
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
        ConstraintLayout(
            modifier = Modifier.fillMaxSize().then(
                Modifier.background(splashscreenBackgroundColor)
            )
        ) {
            val (logoImage, titleText) = createRefs()
            Image(vectorResource(R.drawable.ic_logo),
                modifier = Modifier.constrainAs(logoImage) {
                    centerTo(parent)
                })
            Text(
                stringResource(id = R.string.app_name),
                style = TextStyle(
                    color = Color.White,
                    fontSize = 30.sp,
                    fontWeight = FontWeight.Bold
                ),
                modifier = Modifier.constrainAs(titleText) {
                    top.linkTo(parent.top, margin = 24.dp)
                    centerHorizontallyTo(parent)
                })
        }
    }
}

@Preview
@Composable
fun SplashscreenContent_Preview() {
    SplashscreenContent()
}
