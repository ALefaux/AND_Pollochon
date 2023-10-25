package fr.alefaux.pollochon.core.designsystem.components.skeletons

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import fr.alefaux.pollochon.core.designsystem.theme.PollochonTheme

object PollochonSkeletonColors {
    @Composable
    fun primary(
        backgroundColor: Color = PollochonTheme.colors.pollochonBackgroundTertiary,
        highlightColor: Color = PollochonTheme.colors.pollochonBackgroundPrimary
    ): SkeletonColors = remember(
        backgroundColor,
        highlightColor
    ) {
        SkeletonColors(
            backgroundColor = backgroundColor,
            highlightColor = highlightColor
        )
    }
}