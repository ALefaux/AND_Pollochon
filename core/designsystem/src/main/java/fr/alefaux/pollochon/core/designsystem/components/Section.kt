package fr.alefaux.pollochon.core.designsystem.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import fr.alefaux.pollochon.core.designsystem.pollochonicons.PollochonIcons
import fr.alefaux.pollochon.core.designsystem.pollochonicons.icons.Line
import fr.alefaux.pollochon.core.designsystem.pollochonicons.icons.line.ArrowRight
import fr.alefaux.pollochon.core.designsystem.theme.PollochonTheme

@Composable
fun Section(
    modifier: Modifier = Modifier,
    title: String,
    onSeeAllClicked: () -> Unit,
    content: @Composable () -> Unit
) {
    Column(
        modifier = modifier,
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            Text(
                text = title,
                style = PollochonTheme.typography.h5,
                color = PollochonTheme.colors.pollochonContentPrimary
            )
            IconButton(
                onClick = onSeeAllClicked,
                content = {
                    Icon(
                        imageVector = PollochonIcons.Line.ArrowRight,
                        contentDescription = null,
                        tint = PollochonTheme.colors.pollochonContentPrimary
                    )
                }
            )
        }
        content()
    }
}

@Composable
@Preview(showBackground = true, showSystemUi = true)
fun SectionPreview() {
    PollochonTheme {
        Section(
            title = "Home content section",
            onSeeAllClicked = {},
            content = {}
        )
    }
}