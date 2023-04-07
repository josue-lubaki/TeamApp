package ca.josue_lubaki.teamapp.presentation.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ca.josue_lubaki.teamapp.data.db.local.Profession
import ca.josue_lubaki.teamapp.ui.theme.TeamAppTheme

/**
 * created by Josue Lubaki
 * date : 2023-04-07
 * version : 1.0.0
 */

@Composable
fun ProfileContent(
    fullName : String,
    profession: Profession,
    horizontalAlignment : Alignment.Horizontal = Alignment.Start
) {
    Column(
        modifier = Modifier
            .padding(8.dp),
        horizontalAlignment = horizontalAlignment
    ) {
        Text(
            text = fullName,
            style = MaterialTheme.typography.headlineSmall
        )

        CompositionLocalProvider(
            LocalTextStyle provides MaterialTheme.typography.titleMedium,
        ) {
            Text(
                text = stringResource(id = profession.value),
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun ProfileContentPreview() {
    TeamAppTheme {
        ProfileContent(
            fullName = "Josue Lubaki",
            profession = Profession.DEVELOPER_ANDROID,
            horizontalAlignment = Alignment.CenterHorizontally
        )
    }
}