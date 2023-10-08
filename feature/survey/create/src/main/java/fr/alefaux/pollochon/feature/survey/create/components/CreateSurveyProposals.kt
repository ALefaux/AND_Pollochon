package fr.alefaux.pollochon.feature.survey.create.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import fr.alefaux.pollochon.core.designsystem.pollochonicons.PollochonIcons
import fr.alefaux.pollochon.core.designsystem.pollochonicons.icons.Line
import fr.alefaux.pollochon.core.designsystem.pollochonicons.icons.line.DeleteBin
import fr.alefaux.pollochon.core.designsystem.theme.PollochonTheme

@Composable
internal fun CreateSurveyProposals(
    modifier: Modifier = Modifier,
    proposals: List<String>,
    onProposalClicked: (Int, String) -> Unit,
    onDeleteClicked: (Int) -> Unit,
) {
    Column(
        modifier = modifier
    ) {
        Text(
            modifier = Modifier.padding(top = 8.dp, bottom = 8.dp),
            text = "Propositions (2 mandatories)",
            style = PollochonTheme.typography.body2Bold,
            color = PollochonTheme.colors.pollochonContentPrimary,
        )
        proposals.forEachIndexed { index, proposal ->
            Card(
                modifier = Modifier
                    .padding(bottom = 8.dp)
                    .clickable {
                        onProposalClicked(index, proposal)
                    },
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(16.dp),
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Text(
                        modifier = Modifier
                            .padding(start = 16.dp)
                            .weight(1f),
                        text = proposal,
                        style = PollochonTheme.typography.body2,
                    )
                    Icon(
                        modifier = Modifier
                            .padding(16.dp)
                            .clickable {
                                onDeleteClicked(index)
                            },
                        imageVector = PollochonIcons.Line.DeleteBin,
                        contentDescription = null
                    )
                }
            }
        }
    }
}

@Composable
@Preview(showBackground = true)
fun CreateSurveyProposalsPreview() {
    PollochonTheme {
        CreateSurveyProposals(
            proposals = listOf("Prop 1", "Prop 2"),
            onProposalClicked = { _, _ -> },
            onDeleteClicked = {}
        )
    }
}
