package fr.alefaux.pollochon.core.designsystem.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.ProvideTextStyle
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.remember

@Composable
fun PollochonTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val palette = if (darkTheme) pollochonDarkColorPalette else pollochonLightColorPalette
    ProvidePollochonResources(colors = palette, pollochonTypography) {
        MaterialTheme(
            colors = debugColors(darkTheme, palette),
            typography = mdTypography,
            shapes = shapes,
            content = content
        )
    }
}

@Composable
fun ProvidePollochonResources(
    colors: PollochonColors,
    typography: PollochonTypography,
    content: @Composable () -> Unit
) {
    val colorPalette = remember { colors }
    colorPalette.update(colors)

    CompositionLocalProvider(
        LocalPollochonColors provides colorPalette,
        LocalPollochonTypographies provides typography,
    ) {
        ProvideTextStyle(value = typography.body1, content = content)
    }
}

object PollochonTheme {
    val colors: PollochonColors
        @Composable
        get() = LocalPollochonColors.current

    val typography: PollochonTypography
        @Composable
        get() = LocalPollochonTypographies.current
}
