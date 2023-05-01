package fr.alefaux.login.firstconnection

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.TextField
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import fr.alefaux.pollochon.core.designsystem.theme.PollochonTheme

@Composable
fun FirstConnectionScreen(
    modifier: Modifier = Modifier,
    isPseudoInError: Boolean,
    onRegisterButtonClicked: (String) -> Unit
) {
    var pseudo by remember { mutableStateOf("") }
    Column(
        modifier = modifier.padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Text("First connection?")
        Text("Get a name for your profile")
        TextField(
            value = pseudo,
            onValueChange = { pseudo = it },
            isError = isPseudoInError,
            singleLine = true
        )
        Button(onClick = {
            onRegisterButtonClicked(pseudo)
        }) {
            Text("Enregistrer")
        }
    }
}

@Composable
@Preview(showBackground = true)
fun FirstConnectionPreview() {
    PollochonTheme {
        FirstConnectionScreen(
            isPseudoInError = false
        ) {}
    }
}
