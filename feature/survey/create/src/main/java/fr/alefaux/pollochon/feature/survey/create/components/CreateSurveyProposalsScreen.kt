package fr.alefaux.pollochon.feature.survey.create.components

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import fr.alefaux.pollochon.core.designsystem.components.buttons.PollochonButtons
import fr.alefaux.pollochon.core.designsystem.theme.PollochonTheme
import fr.alefaux.pollochon.feature.survey.create.R

@Composable
fun CreateSurveyProposalsScreen(
    modifier: Modifier = Modifier,
    isSendingSurvey: Boolean,
    proposals: List<String>,
    onPreviousClicked: (List<String>) -> Unit,
    onValidateClicked: (List<String>) -> Unit,
) {
    val context: Context = LocalContext.current
    var proposalsState by remember { mutableStateOf(proposals) }

    Column(
        modifier = modifier
    ) {
        CreateSurveyProposals(
            proposals = proposalsState,
            onAddProposalClicked = {
                val newProposals = proposalsState.toMutableList()
                newProposals.add("")
                proposalsState = newProposals
            },
            onDeleteClicked = { index ->
                val newProposals = proposalsState.toMutableList()
                newProposals.removeAt(index)
                proposalsState = newProposals
            },
            onProposalTextChanged = { index, text ->
                val newProposals = proposalsState.toMutableList()
                newProposals[index] = text
                proposalsState = newProposals
            }
        )
        Spacer(modifier = Modifier.weight(1f))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.End
        ) {
            PollochonButtons.Ghost(
                text = "Précédent",
                onClick = {
                    onPreviousClicked(proposalsState)
                }
            )
            Box(
                contentAlignment = Alignment.Center,
            ) {
                PollochonButtons.Primary(
                    text = if(isSendingSurvey) "" else "Créer",
                    onClick = {
                        if (proposalsState.size >= 2) {
                            onValidateClicked(proposalsState)
                        } else {
                            Toast.makeText(
                                context,
                                context.getString(R.string.create_survey_make_proposals),
                                Toast.LENGTH_LONG
                            ).show()
                        }
                    }
                )
                if(isSendingSurvey) {
                    CircularProgressIndicator(
                        color = PollochonTheme.colors.pollochonContentPrimaryReversed
                    )
                }
            }
        }
    }
}

@Composable
@Preview(showBackground = true)
fun CreateSurveyProposalsScreenPreview() {
    PollochonTheme {
        CreateSurveyProposalsScreen(
            proposals = emptyList(),
            isSendingSurvey = false,
            onPreviousClicked = {},
            onValidateClicked = {},
        )
    }
}
