package fr.alefaux.pollochon.feature.survey.create.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import fr.alefaux.pollochon.core.designsystem.components.textinputs.PollochonTextInputs
import fr.alefaux.pollochon.core.designsystem.pollochonicons.PollochonIcons
import fr.alefaux.pollochon.core.designsystem.pollochonicons.icons.Line
import fr.alefaux.pollochon.core.designsystem.pollochonicons.icons.line.DeleteBin
import fr.alefaux.pollochon.core.designsystem.theme.PollochonTheme
import timber.log.Timber

@Composable
fun CreateSurveyProposalCard(
    modifier: Modifier = Modifier,
    index: Int,
    proposal: String,
    onProposalTextChanged: (Int, String) -> Unit,
    onDeleteClicked: (Int) -> Unit
) {
    var isEditing by remember { mutableStateOf(proposal.isBlank()) }
    var text by remember { mutableStateOf(proposal) }

    Card(
        modifier = modifier
            .padding(bottom = 8.dp)
            .clickable {},
    ) {
        if (isEditing) {
            PollochonTextInputs.Filled(
                value = text,
                label = "Proposal text",
                onValueChange = { textChanged ->
                    text = textChanged
                },
                keyboardActions = KeyboardActions {
                    isEditing = false
                    onProposalTextChanged(index, text)
                },
                keyboardOptions = KeyboardOptions(
                    imeAction = ImeAction.Done,
                )
            )
        } else {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable {
                        isEditing = true
                    },
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Text(
                    modifier = Modifier
                        .padding(start = 16.dp)
                        .weight(1f),
                    text = text,
                    style = PollochonTheme.typography.body2,
                )
                Icon(
                    modifier = Modifier
                        .padding(16.dp)
                        .clickable {
                            Timber.d("[ALE] Delete clicked at $index")
                            onDeleteClicked(index)
                        },
                    imageVector = PollochonIcons.Line.DeleteBin,
                    contentDescription = null
                )
            }
        }
    }
}