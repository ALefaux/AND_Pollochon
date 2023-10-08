package fr.alefaux.pollochon.core.designsystem.components.textinputs

import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.semantics
import fr.alefaux.pollochon.core.designsystem.components.textinputs.semantics.editableCounter
import fr.alefaux.pollochon.core.designsystem.components.textinputs.semantics.editableHelperText

/**
 * Apply custom semantics to Vitamin TextInput components.
 * @param helperText Optional helper text attached to the TextInput
 * @param counter Optional counter attached to the TextInput
 */
internal fun Modifier.pollochonSemantics(
    helperText: String?,
    counter: Pair<Int, Int>?
) = semantics {
    if (helperText != null) {
        this.editableHelperText = helperText
    }
    if (counter != null) {
        this.editableCounter = counter
    }
}