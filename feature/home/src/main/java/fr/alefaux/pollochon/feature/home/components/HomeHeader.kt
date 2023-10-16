package fr.alefaux.pollochon.feature.home.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import fr.alefaux.pollochon.core.designsystem.theme.PollochonTheme

@Composable
fun HomeHeader(
    modifier: Modifier = Modifier,
    title: String
) {
    Row(
        modifier = modifier
            .height(height = 100.dp)
            .fillMaxWidth(),
        verticalAlignment = Alignment.Bottom
    ) {
        Text(
            text = title,
            style = PollochonTheme.typography.h1,
            color = PollochonTheme.colors.pollochonContentPrimary,
        )
    }
}