package ca.josue_lubaki.teamapp.presentation.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ca.josue_lubaki.teamapp.R
import ca.josue_lubaki.teamapp.data.db.local.Profession
import ca.josue_lubaki.teamapp.domain.models.UserEntity
import ca.josue_lubaki.teamapp.ui.theme.TeamAppTheme
import ca.josue_lubaki.teamapp.ui.theme.dimensions

/**
 * created by Josue Lubaki
 * date : 2023-04-07
 * version : 1.0.0
 */

@Composable
fun ProfileCard(
    userEntity: UserEntity,
    onClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .padding(all = MaterialTheme.dimensions.small)
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.surface)
            .wrapContentHeight(align = Alignment.Top)
            .clickable(
                onClick = { onClick.invoke() },
                onClickLabel = stringResource(R.string.click_to_see_user_details)
            ),
        elevation = CardDefaults.cardElevation(MaterialTheme.dimensions.micro),
        border =
            if (!isSystemInDarkTheme())
                    BorderStroke(
                        width = MaterialTheme.dimensions.borderStrokeDefault,
                        color = MaterialTheme.colorScheme.onBackground
                    )
            else null,
    ) {

        val (_, fullName, imageURL, profession) = userEntity
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start
        ) {
            ProfilePicture(imageURL)
            ProfileContent(fullName, profession)
        }
    }
}

@Preview
@Composable
fun ProfileCardPreview() {
    TeamAppTheme {
        ProfileCard(
            userEntity = UserEntity(
                id = 1,
                fullName = "Josue Lubaki",
                imageURL = "https://avatars.githubusercontent.com/u/47045498?v=4",
                profession = Profession.DEVELOPER_ANDROID
            ),
            onClick = { /*TODO*/ }
        )
    }
}