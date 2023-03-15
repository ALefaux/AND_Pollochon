package fr.alefaux.pollochon.core.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import fr.alefaux.pollochon.core.designsystem.theme.PollochonTheme

object GenericView {

    @Composable
    fun Empty(modifier: Modifier = Modifier) =
        GenericViewImpl(
            modifier = modifier,
            text = "There is no data for now"
        )

    @Composable
    fun Error(modifier: Modifier = Modifier) =
        GenericViewImpl(
            modifier = modifier,
            text = "Oups ... Something went wrong ... Please try again."
        )

    @Composable
    internal fun GenericViewImpl(
        modifier: Modifier,
        text: String,
    ) {
        Box(
            modifier = modifier.padding(16.dp),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(R.drawable.ic_logo),
                contentDescription = null,
                modifier = Modifier.fillMaxWidth().alpha(0.3f)
            )
            Text(
                text = text,
                textAlign = TextAlign.Center
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GenericErrorPreview() {
    PollochonTheme {
        GenericView.Error()
    }
}

@Preview(showBackground = true)
@Composable
fun GenericEmptyPreview() {
    PollochonTheme {
        GenericView.Empty()
    }
}
