package ca.josue_lubaki.teamapp.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import ca.josue_lubaki.teamapp.data.db.local.Profession
import ca.josue_lubaki.teamapp.ui.theme.TeamAppTheme
import ca.josue_lubaki.teamapp.ui.theme.dimensions
import ca.josue_lubaki.teamapp.utils.Extension.showPlaceholder

/**
 * created by Josue Lubaki
 * date : 2023-04-07
 * version : 1.0.0
 */

@Composable
fun ProfileContent(
    fullName : String,
    profession: Profession,
    showPlaceholder: Boolean = false,
    horizontalAlignment : Alignment.Horizontal = Alignment.Start,
    textStyle: TextStyle = MaterialTheme.typography.headlineSmall
) {
    Column(
        modifier = Modifier.padding(MaterialTheme.dimensions.small),
        horizontalAlignment = horizontalAlignment,
        verticalArrangement = Arrangement.spacedBy(MaterialTheme.dimensions.micro)
    ) {
        Text(
            text = fullName,
            style = textStyle,
            modifier = Modifier.showPlaceholder(visible = showPlaceholder),
        )

        CompositionLocalProvider(
            LocalTextStyle provides MaterialTheme.typography.titleMedium,
        ) {
            Text(
                text = stringResource(id = profession.value),
                modifier = Modifier.showPlaceholder(visible = showPlaceholder),
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
            horizontalAlignment = Alignment.CenterHorizontally,
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun ProfileContentShimmerPreview() {
    TeamAppTheme {
        ProfileContent(
            fullName = "Josue Lubaki",
            profession = Profession.DEVELOPER_ANDROID,
            horizontalAlignment = Alignment.CenterHorizontally,
            showPlaceholder = true,
        )
    }
}