package fr.alefaux.pollochon.feature.survey.create

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import fr.alefaux.pollochon.core.designsystem.theme.PollochonTheme
import org.koin.androidx.compose.koinViewModel

@Composable
fun CreateSurveyScreen(
    viewModel: CreateSurveyViewModel = koinViewModel()
) {
    HeaderScreen(title = R.string.title_create_survey)
}

@Composable
fun HeaderScreen(
    @StringRes title: Int,
) {
    Row(
        modifier = Modifier.height(height = 100.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {
        Text(
            text = stringResource(id = title),
            style = PollochonTheme
        )
        Icon(painter = painterResource(id = R.drawable.ic_account), contentDescription = null)
    }
}

@Composable
@Preview
fun CreateSurveyScreenPreview() {
    PollochonTheme {
        CreateSurveyScreen()
    }
}

@Composable
@Preview(showBackground = true, widthDp = 300)
fun HeaderScreenPreview() {
    PollochonTheme {
        HeaderScreen(title = R.string.title_create_survey)
    }
}
