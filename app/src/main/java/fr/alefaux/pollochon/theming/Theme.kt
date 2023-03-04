package fr.alefaux.pollochon.theming

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable

@Composable
fun PollochonTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        typography = typography,
        shapes = shapes,
        content = content
    )

}