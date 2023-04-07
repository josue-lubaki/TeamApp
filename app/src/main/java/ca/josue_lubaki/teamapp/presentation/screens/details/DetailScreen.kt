package ca.josue_lubaki.teamapp.presentation.screens.details

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ca.josue_lubaki.teamapp.R
import ca.josue_lubaki.teamapp.data.db.local.Profession
import ca.josue_lubaki.teamapp.domain.models.UserEntity
import ca.josue_lubaki.teamapp.presentation.components.AppBar
import ca.josue_lubaki.teamapp.presentation.components.ProfileContent
import ca.josue_lubaki.teamapp.presentation.components.ProfilePicture
import ca.josue_lubaki.teamapp.ui.theme.TeamAppTheme

/**
 * created by Josue Lubaki
 * date : 2023-04-07
 * version : 1.0.0
 */

@Composable
fun DetailScreenContainer(
    id: Int,
    viewModel: DetailsViewModel,
    onBackPressed: () -> Unit
) {
    val user = viewModel.onGetUserById(id)
    DetailsScreen(
        user = user,
        onBackPressed = onBackPressed
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun DetailsScreen(
    user: UserEntity,
    onBackPressed: () -> Unit
) {
    Scaffold(
        topBar = {
            AppBar(
                title = stringResource(R.string.user_profile_details),
                icon = Icons.Default.ArrowBack,
                iconClickAction = { onBackPressed() }
            )
        }
    ) { paddingValues ->
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
            color = MaterialTheme.colorScheme.primaryContainer.copy(alpha = 0.1f)
        ) {
            val (_, fullName, imageURL, profession) = user
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 24.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Top
            ) {
                ProfilePicture(imageURL, imageSize = 160.dp)
                ProfileContent(
                    fullName = fullName,
                    profession = profession,
                    horizontalAlignment = Alignment.CenterHorizontally
                )
            }
        }
    }
}

@Preview
@Composable
fun DetailsScreenPreview() {
    TeamAppTheme {
        DetailsScreen(
            user = UserEntity(
                id = 1,
                fullName = "Josue Lubaki",
                imageURL = "https://avatars.githubusercontent.com/u/16869302?v=4",
                profession = Profession.DEVELOPER_ANDROID
            ),
            onBackPressed = {}
        )
    }
}