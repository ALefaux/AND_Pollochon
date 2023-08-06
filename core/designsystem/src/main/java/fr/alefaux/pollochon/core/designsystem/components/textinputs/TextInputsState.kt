package fr.alefaux.pollochon.core.designsystem.components.textinputs

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import fr.alefaux.pollochon.core.designsystem.pollochonicons.PollochonIcons
import fr.alefaux.pollochon.core.designsystem.pollochonicons.icons.Line
import fr.alefaux.pollochon.core.designsystem.pollochonicons.icons.line.Check
import fr.alefaux.pollochon.core.designsystem.pollochonicons.icons.line.ErrorWarning
import fr.alefaux.pollochon.core.designsystem.theme.PollochonTheme

enum class State { NORMAL, ERROR, SUCCESS }

@Immutable
class TextInputStateColors(
    val textColor: Color,
    val focusTextColor: Color,
    val borderColor: Color,
    val focusBorderColor: Color,
    val helperColor: Color,
    val iconColor: Color,
    val imageVector: ImageVector?,
    val state: State
)

object TextInputsState {
    @Composable
    fun normal(
        textColor: Color = PollochonTheme.colors.pollochonContentTertiary,
        focusTextColor: Color = PollochonTheme.colors.pollochonBorderActive,
        borderColor: Color = PollochonTheme.colors.pollochonContentTertiary,
        focusBorderColor: Color = PollochonTheme.colors.pollochonBorderActive,
        helperColor: Color = PollochonTheme.colors.pollochonContentTertiary,
        iconColor: Color = PollochonTheme.colors.pollochonContentPrimary,
    ): TextInputStateColors = remember(
        textColor, focusTextColor, borderColor, focusBorderColor, helperColor, iconColor
    ) {
        TextInputStateColors(
            textColor = textColor,
            focusTextColor = focusTextColor,
            borderColor = borderColor,
            focusBorderColor = focusBorderColor,
            helperColor = helperColor,
            iconColor = iconColor,
            imageVector = null,
            state = State.NORMAL
        )
    }

    @Composable
    fun error(
        textColor: Color = PollochonTheme.colors.pollochonContentNegative,
        focusTextColor: Color = PollochonTheme.colors.pollochonContentNegative,
        borderColor: Color = PollochonTheme.colors.pollochonBorderNegative,
        focusBorderColor: Color = PollochonTheme.colors.pollochonBorderNegative,
        helperColor: Color = PollochonTheme.colors.pollochonContentTertiary,
        iconColor: Color = PollochonTheme.colors.pollochonBorderNegative,
        imageVector: ImageVector = PollochonIcons.Line.ErrorWarning
    ): TextInputStateColors = remember(
        textColor, focusTextColor, borderColor, focusBorderColor, helperColor, iconColor
    ) {
        TextInputStateColors(
            textColor = textColor,
            focusTextColor = focusTextColor,
            borderColor = borderColor,
            focusBorderColor = focusBorderColor,
            helperColor = helperColor,
            iconColor = iconColor,
            imageVector = imageVector,
            state = State.ERROR
        )
    }

    @Composable
    fun success(
        textColor: Color = PollochonTheme.colors.pollochonContentPrimary,
        focusTextColor: Color = PollochonTheme.colors.pollochonContentPrimary,
        borderColor: Color = PollochonTheme.colors.pollochonBorderPositive,
        focusBorderColor: Color = PollochonTheme.colors.pollochonBorderPositive,
        helperColor: Color = PollochonTheme.colors.pollochonContentTertiary,
        iconColor: Color = PollochonTheme.colors.pollochonBorderPositive,
        imageVector: ImageVector = PollochonIcons.Line.Check
    ): TextInputStateColors = remember(
        textColor, focusTextColor, borderColor, focusBorderColor, helperColor, iconColor
    ) {
        TextInputStateColors(
            textColor = textColor,
            focusTextColor = focusTextColor,
            borderColor = borderColor,
            focusBorderColor = focusBorderColor,
            helperColor = helperColor,
            iconColor = iconColor,
            imageVector = imageVector,
            state = State.SUCCESS
        )
    }
}