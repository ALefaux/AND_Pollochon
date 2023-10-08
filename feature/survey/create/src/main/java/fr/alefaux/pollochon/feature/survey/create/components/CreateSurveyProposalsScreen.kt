package fr.alefaux.pollochon.feature.survey.create.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import fr.alefaux.pollochon.core.designsystem.components.buttons.PollochonButtons
import fr.alefaux.pollochon.core.designsystem.components.textinputs.PollochonTextInputs
import fr.alefaux.pollochon.core.designsystem.pollochonicons.PollochonIcons
import fr.alefaux.pollochon.core.designsystem.pollochonicons.icons.Line
import fr.alefaux.pollochon.core.designsystem.pollochonicons.icons.line.Close
import fr.alefaux.pollochon.core.designsystem.theme.PollochonTheme

@Composable
fun CreateSurveyProposalsScreen(
    modifier: Modifier = Modifier,
    proposals: List<String>,
    proposal: String,
    onProposalTextChanged: (String) -> Unit,
    onProposalValidated: (Int?, String) -> Unit,
    onPreviousClicked: () -> Unit,
    onValidateClicked: () -> Unit
) {
    Column(
        modifier = modifier
    ) {
        CreateSurveyProposals(
            proposals = proposals,
            onProposalClicked = { index, proposal ->

            },
            onDeleteClicked = { index ->

            }
        )
        Card {
            PollochonTextInputs.Filled(
                value = proposal,
                label = "Proposal text",
                onValueChange = onProposalTextChanged,
                icon = {
                    Icon(
                        modifier = Modifier.clickable {
                            onProposalTextChanged("")
                        },
                        imageVector = PollochonIcons.Line.Close,
                        contentDescription = null,
                    )
                },
                keyboardActions = KeyboardActions {
                    if (proposal.isNotBlank()) {
                        onProposalValidated(null, proposal)
                    }
                },
                keyboardOptions = KeyboardOptions(
                    imeAction = ImeAction.Done,
                ),
            )
        }
        Spacer(modifier = Modifier.weight(1f))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.End
        ) {
            PollochonButtons.Ghost(
                text = "Précédent",
                onClick = onPreviousClicked
            )
            PollochonButtons.Primary(
                text = "Créer",
                onClick = onValidateClicked
            )
        }
    }
}

@Composable
@Preview(showBackground = true)
fun CreateSurveyProposalsScreenPreview() {
    PollochonTheme {
        CreateSurveyProposalsScreen(
            proposals = listOf("Prop 1", "Prop 2"),
            proposal = "Prop 3",
            onProposalTextChanged = {},
            onProposalValidated = { _, _ -> },
            onPreviousClicked = {},
            onValidateClicked = {}
        )
    }
}
