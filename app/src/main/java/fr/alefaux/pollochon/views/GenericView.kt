package fr.alefaux.pollochon.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import fr.alefaux.pollochon.R
import fr.alefaux.pollochon.theming.PollochonTheme

@Composable
fun GenericView(modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        Column(modifier = Modifier.weight(1f)) {
            Image(
                painter = painterResource(R.drawable.ic_logo),
                contentDescription = null,
                modifier = Modifier.fillMaxWidth()
            )
        }
        Column(modifier = Modifier.weight(1f)) {
            Text("Oups ... Something went wrong ... Please try again.")

        }
    }
}

@Preview(showBackground = true)
@Composable
fun GenericPreview() {
    PollochonTheme {
        GenericView()
    }
}