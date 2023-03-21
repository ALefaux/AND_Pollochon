package fr.alefaux.pollochon.feature.profile.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import fr.alefaux.pollochon.feature.profile.model.ProfileUi

@Composable
fun ProfileContentView(
    profileUi: ProfileUi,
    onLogoutButtonClicked: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        if (!profileUi.userImageUrl.isNullOrBlank()) {
            ProfileImage(
                url = profileUi.userImageUrl
            ) {}
        }
        Text(profileUi.userName)
        Spacer(modifier = Modifier.weight(1f))
        Button(
            onClick = onLogoutButtonClicked
        ) {
            Text("Déconnexion")
        }
    }
}
