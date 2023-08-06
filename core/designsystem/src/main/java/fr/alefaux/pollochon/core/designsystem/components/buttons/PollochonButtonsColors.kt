package fr.alefaux.pollochon.core.designsystem.components.buttons

import androidx.compose.material.ButtonColors
import androidx.compose.material.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import fr.alefaux.pollochon.core.designsystem.theme.PollochonStatesDisabled
import fr.alefaux.pollochon.core.designsystem.theme.PollochonTheme

object PollochonButtonsColors {
    @Composable
    fun primary(
        backgroundColor: Color = PollochonTheme.colors.pollochonBackgroundBrandPrimary,
        contentColor: Color = PollochonTheme.colors.pollochonContentPrimaryReversed,
        disabledBackgroundColor: Color = PollochonTheme.colors.pollochonBackgroundBrandPrimary
            .copy(alpha = PollochonStatesDisabled),
        disabledContentColor: Color = PollochonTheme.colors.pollochonContentPrimaryReversed
            .copy(alpha = PollochonStatesDisabled)
    ): ButtonColors = ButtonDefaults.buttonColors(
        backgroundColor = backgroundColor,
        contentColor = contentColor,
        disabledBackgroundColor = disabledBackgroundColor,
        disabledContentColor = disabledContentColor
    )
}