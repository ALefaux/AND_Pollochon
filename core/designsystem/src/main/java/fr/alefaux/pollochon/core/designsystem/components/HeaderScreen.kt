package fr.alefaux.pollochon.core.designsystem.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import fr.alefaux.pollochon.core.designsystem.R
import fr.alefaux.pollochon.core.designsystem.theme.PollochonTheme

@Composable
fun HeaderScreen(
    modifier: Modifier = Modifier,
    title: String,
    onAccountClicked: () -> Unit
) {
    Row(
        modifier = modifier
            .height(height = 100.dp)
            .fillMaxWidth(),
        verticalAlignment = Alignment.Bottom,
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {
        Text(
            text = title,
            style = PollochonTheme.typography.h1,
            color = PollochonTheme.colors.pollochonContentPrimary,
        )
        IconButton(
            onClick = onAccountClicked
        ) {
            Icon(
                modifier = Modifier.size(32.dp),
                painter = painterResource(id = R.drawable.ic_account),
                tint = PollochonTheme.colors.pollochonContentPrimary,
                contentDescription = null,
            )
        }

    }
}

@Composable
@Preview(showBackground = true, widthDp = 400)
fun HeaderScreenPreview() {
    PollochonTheme {
        HeaderScreen(
            title = "Header screen",
            onAccountClicked = {},
        )
    }
}
