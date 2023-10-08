package fr.alefaux.pollochon.core.designsystem.components.textinputs

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.ContentAlpha
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import fr.alefaux.pollochon.core.designsystem.theme.PollochonTheme

object PollochonTextInputs {
    /**
     * Outlined text input to get an input value from the user.
     * @param value The value of your text input
     * @param label The label to be displayed inside the text input container and pushed at the top
     * of text input when the component takes the focus
     * @param onValueChange The callback to be called when the user type a new character
     * @param modifier The `Modifier` to be applied to the component
     * @param helperText The optional helper text to be displayed at the start bottom outside the text input container
     * @param counter The optional counter to be displayed the the end bottom outside the text input container
     * @param singleLine True if the text input doesn't extend their height, otherwise, false
     * @param maxLines The number of maximum lines the text input can have if the `singleLine` is set to `true`
     * @param readOnly True if you don't want open the keyboard when the user click on the text field
     * @param enabled True if you can type in the text input, otherwise false
     * @param transformation Transforms the visual representation of the input value
     * @param keyboardOptions When the text input emit an IME action, the corresponding callback is called
     * @param keyboardActions Software keyboard options that contains such as KeyboardType and ImeAction
     * @param interactionSource Representing the stream of interaction for the text input
     * @param colors The color to notify your user if they are in normal, error or success state
     * @param textStyle The typography of the text inside the text input
     * @param icon The optional trailing icon to be displayed at the end of the text input container
     */
    @Composable
    fun Outlined(
        value: String,
        onValueChange: (String) -> Unit,
        label: String = "",
        modifier: Modifier = Modifier,
        helperText: String? = null,
        counter: Pair<Int, Int>? = null,
        singleLine: Boolean = false,
        maxLines: Int = Int.MAX_VALUE,
        readOnly: Boolean = false,
        enabled: Boolean = true,
        transformation: VisualTransformation = TextInputsTransformations.none,
        keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
        keyboardActions: KeyboardActions = KeyboardActions.Default,
        interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
        colors: TextInputStateColors = TextInputsState.normal(),
        textStyle: TextStyle = PollochonTheme.typography.body2,
        icon: @Composable (() -> Unit)? = null
    ) {
        PollochonTextInputLayoutImpl(
            helperText = helperText,
            counter = counter,
            colors = colors,
            enabled = enabled,
            textInput = {
                OutlinedTextField(
                    value = value,
                    onValueChange = onValueChange,
                    label = { Text(text = label) },
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        backgroundColor = PollochonTheme.colors.pollochonBackgroundPrimary,
                        cursorColor = PollochonTheme.colors.pollochonContentAction,
                        errorCursorColor = PollochonTheme.colors.pollochonContentNegative,
                        textColor = PollochonTheme.colors.pollochonContentPrimary,
                        disabledTextColor = PollochonTheme.colors.pollochonContentTertiary.copy(
                            ContentAlpha.disabled
                        ),
                        focusedBorderColor = colors.focusBorderColor,
                        unfocusedBorderColor = colors.borderColor,
                        disabledBorderColor = PollochonTheme.colors.pollochonActiveTertiary.copy(
                            ContentAlpha.disabled
                        ),
                        errorBorderColor = colors.borderColor,
                        leadingIconColor = colors.iconColor,
                        disabledLeadingIconColor = PollochonTheme.colors.pollochonActiveTertiary.copy(
                            ContentAlpha.disabled
                        ),
                        errorLeadingIconColor = colors.iconColor,
                        trailingIconColor = colors.iconColor,
                        disabledTrailingIconColor = PollochonTheme.colors.pollochonContentPrimary.copy(
                            ContentAlpha.disabled
                        ),
                        errorTrailingIconColor = colors.iconColor,
                        focusedLabelColor = colors.focusTextColor,
                        unfocusedLabelColor = colors.textColor,
                        disabledLabelColor = PollochonTheme.colors.pollochonContentTertiary.copy(
                            ContentAlpha.disabled
                        ),
                        errorLabelColor = colors.textColor
                    ),
                    textStyle = textStyle,
                    visualTransformation = transformation,
                    interactionSource = interactionSource,
                    keyboardOptions = keyboardOptions,
                    keyboardActions = keyboardActions,
                    singleLine = singleLine,
                    maxLines = maxLines,
                    modifier = Modifier.fillMaxWidth(),
                    enabled = enabled,
                    readOnly = readOnly,
                    isError = colors.state == State.ERROR,
                    trailingIcon = {
                        if (icon != null && colors.state != State.SUCCESS) {
                            icon()
                        } else if (
                            colors.imageVector != null &&
                            (colors.state == State.SUCCESS || colors.state == State.ERROR)
                        ) {
                            Icon(
                                imageVector = colors.imageVector,
                                contentDescription = null
                            )
                        }
                    }
                )
            },
            modifier = modifier
        )
    }

    /**
     * Filled text input to get an input value from the user.
     * @param value The value of your text input
     * @param label The label to be displayed inside the text input container and pushed at the top
     * of text input when the component takes the focus
     * @param onValueChange The callback to be called when the user type a new character
     * @param modifier The `Modifier` to be applied to the component
     * @param helperText The optional helper text to be displayed at the start bottom outside the text input container
     * @param counter The optional counter to be displayed the the end bottom outside the text input container
     * @param maxLines The number of maximum lines the text input can have if the `singleLine` is set to `true`
     * @param singleLine True if the text input doesn't extend their height, otherwise, false
     * @param readOnly True if you don't want open the keyboard when the user click on the text field
     * @param enabled True if you can type in the text input, otherwise false
     * @param transformation Transforms the visual representation of the input value
     * @param keyboardOptions When the text input emit an IME action, the corresponding callback is called
     * @param keyboardActions Software keyboard options that contains such as KeyboardType and ImeAction
     * @param interactionSource Representing the stream of interaction for the text input
     * @param colors The color to notify your user if they are in normal, error or success state
     * @param textStyle The typography of the text inside the text input
     * @param icon The optional trailing icon to be displayed at the end of the text input container
     */
    @Composable
    fun Filled(
        value: String,
        label: String,
        onValueChange: (String) -> Unit,
        modifier: Modifier = Modifier,
        helperText: String? = null,
        counter: Pair<Int, Int>? = null,
        maxLines: Int = Int.MAX_VALUE,
        singleLine: Boolean = false,
        readOnly: Boolean = false,
        enabled: Boolean = true,
        transformation: VisualTransformation = TextInputsTransformations.none,
        keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
        keyboardActions: KeyboardActions = KeyboardActions.Default,
        interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
        colors: TextInputStateColors = TextInputsState.normal(),
        textStyle: TextStyle = PollochonTheme.typography.body2,
        icon: @Composable (() -> Unit)? = null,
    ) {
        PollochonTextInputLayoutImpl(
            helperText = helperText,
            counter = counter,
            colors = colors,
            enabled = enabled,
            textInput = {
                TextField(
                    value = value,
                    onValueChange = onValueChange,
                    label = { Text(text = label) },
                    colors = TextFieldDefaults.textFieldColors(
                        backgroundColor = PollochonTheme.colors.pollochonBackgroundPrimary,
                        cursorColor = PollochonTheme.colors.pollochonContentAction,
                        errorCursorColor = PollochonTheme.colors.pollochonContentNegative,
                        textColor = PollochonTheme.colors.pollochonContentPrimary,
                        disabledTextColor = PollochonTheme.colors.pollochonContentTertiary.copy(ContentAlpha.disabled),
                        focusedIndicatorColor = colors.focusBorderColor,
                        unfocusedIndicatorColor = colors.borderColor,
                        disabledIndicatorColor = PollochonTheme.colors.pollochonActiveTertiary.copy(
                            ContentAlpha.disabled,
                        ),
                        errorIndicatorColor = colors.borderColor,
                        leadingIconColor = colors.iconColor,
                        disabledLeadingIconColor = PollochonTheme.colors.pollochonActiveTertiary.copy(
                            ContentAlpha.disabled,
                        ),
                        errorLeadingIconColor = colors.iconColor,
                        trailingIconColor = colors.iconColor,
                        disabledTrailingIconColor = PollochonTheme.colors.pollochonContentPrimary.copy(
                            ContentAlpha.disabled,
                        ),
                        errorTrailingIconColor = colors.iconColor,
                        focusedLabelColor = colors.focusTextColor,
                        unfocusedLabelColor = colors.textColor,
                        disabledLabelColor = PollochonTheme.colors.pollochonContentTertiary.copy(
                            ContentAlpha.disabled,
                        ),
                        errorLabelColor = colors.textColor,
                    ),
                    textStyle = textStyle,
                    visualTransformation = transformation,
                    interactionSource = interactionSource,
                    keyboardOptions = keyboardOptions,
                    keyboardActions = keyboardActions,
                    singleLine = singleLine,
                    maxLines = maxLines,
                    modifier = Modifier.fillMaxWidth().pollochonSemantics(helperText, counter),
                    enabled = enabled,
                    isError = colors.state == State.ERROR,
                    readOnly = readOnly,
                    trailingIcon = {
                        if (icon != null && colors.state != State.SUCCESS) {
                            icon()
                        } else if (
                            colors.imageVector != null &&
                            (colors.state == State.SUCCESS || colors.state == State.ERROR)
                        ) {
                            Icon(
                                imageVector = colors.imageVector,
                                contentDescription = null,
                            )
                        }
                    },
                )
            },
            modifier = modifier,
        )
    }
}

@Composable
internal fun PollochonTextInputLayoutImpl(
    helperText: String?,
    counter: Pair<Int, Int>?,
    colors: TextInputStateColors,
    enabled: Boolean,
    textInput: @Composable () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {
        // This is a hack because [Outlined]TextField doesn't expose
        // the label text style configuration. To avoid this restriction,
        // we initialize a MaterialTheme component with the typography of
        // Vitamin.
        MaterialTheme(
            typography = MaterialTheme.typography.copy(
                subtitle1 = PollochonTheme.typography.body2,
                caption = PollochonTheme.typography.caption
            )
        ) {
            textInput()
        }
        Row(modifier = Modifier.padding(vertical = 1.dp, horizontal = 4.dp)) {
            helperText?.let {
                val color = if (!enabled) colors.helperColor.copy(ContentAlpha.disabled)
                else if (colors.state == State.ERROR) colors.textColor
                else colors.helperColor
                Text(
                    text = it,
                    style = PollochonTheme.typography.caption,
                    color = color,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    modifier = Modifier
                        .weight(1f)
                        .padding(end = 4.dp),
                )
            }
            counter?.let {
                val color = if (!enabled) colors.helperColor.copy(ContentAlpha.disabled)
                else colors.helperColor
                Text(
                    text = "${it.first}/${it.second}",
                    style = PollochonTheme.typography.caption,
                    color = color,
                )
            }
        }
    }
}