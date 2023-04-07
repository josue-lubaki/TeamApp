package ca.josue_lubaki.teamapp.presentation.screens.users

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ca.josue_lubaki.teamapp.R
import ca.josue_lubaki.teamapp.data.db.local.Profession
import ca.josue_lubaki.teamapp.domain.models.UserEntity
import ca.josue_lubaki.teamapp.presentation.components.AppBar
import ca.josue_lubaki.teamapp.presentation.components.ProfileCard
import ca.josue_lubaki.teamapp.ui.theme.TeamAppTheme

/**
 * created by Josue Lubaki
 * date : 2023-04-07
 * version : 1.0.0
 */
@Composable
fun UserScreenContainer(
    viewModel: UserViewModel,
    onSelected: (Int) -> Unit
) {
    val usersList = viewModel.users

    UserScreen(
        usersList = usersList,
        onSelected = onSelected
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UserScreen(
    usersList: List<UserEntity>,
    onSelected: (Int) -> Unit
) {
    Scaffold(
        topBar = {
            AppBar(
                title = stringResource(R.string.users_list),
                icon = Icons.Default.Home,
            )
        }
    ) { paddingValues ->
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
            color = MaterialTheme.colorScheme.primaryContainer.copy(alpha = 0.1f)
        ) {
            LazyColumn(
                modifier = Modifier.padding(
                    horizontal = 8.dp,
                    vertical = 4.dp
                )
            ) {
                items(
                    items = usersList,
                    key = { userEntity -> userEntity.id },
                    contentType = { userEntity -> userEntity.id }
                ) { userEntity ->
                    ProfileCard(
                        userEntity = userEntity,
                        onClick = { onSelected(userEntity.id) }
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun UserScreenPreview() {
    TeamAppTheme {
        UserScreen(
            onSelected = { },
            usersList = listOf(
                UserEntity(
                    id = 1,
                    fullName = "Josue Lubaki",
                    imageURL = "https://avatars.githubusercontent.com/u/47000000?v=4",
                    profession = Profession.DEVELOPER_ANDROID
                ),
                UserEntity(
                    id = 2,
                    fullName = "Josue Lubaki",
                    imageURL = "https://avatars.githubusercontent.com/u/47000000?v=4",
                    profession = Profession.DEVELOPER_ANDROID
                ),
                UserEntity(
                    id = 3,
                    fullName = "Josue Lubaki",
                    imageURL = "https://avatars.githubusercontent.com/u/47000000?v=4",
                    profession = Profession.DEVELOPER_ANDROID
                ),
                UserEntity(
                    id = 4,
                    fullName = "Josue Lubaki",
                    imageURL = "https://avatars.githubusercontent.com/u/47000000?v=4",
                    profession = Profession.DEVELOPER_ANDROID
                ),
                UserEntity(
                    id = 5,
                    fullName = "Josue Lubaki",
                    imageURL = "https://avatars.githubusercontent.com/u/47000000?v=4",
                    profession = Profession.DEVELOPER_ANDROID
                ),
                UserEntity(
                    id = 6,
                    fullName = "Josue Lubaki",
                    imageURL = "https://avatars.githubusercontent.com/u/47000000?v=4",
                    profession = Profession.DEVELOPER_ANDROID
                ),
                UserEntity(
                    id = 7,
                    fullName = "Josue Lubaki",
                    imageURL = "https://avatars.githubusercontent.com/u/47000000?v=4",
                    profession = Profession.DEVELOPER_ANDROID
                ),
                UserEntity(
                    id = 8,
                    fullName = "Josue Lubaki",
                    imageURL = "https://avatars.githubusercontent.com/u/47000000?v=4",
                    profession = Profession.DEVELOPER_ANDROID
                ),
                UserEntity(
                    id = 9,
                    fullName = "Josue Lubaki",
                    imageURL = "https://avatars.githubusercontent.com/u/47000000?v=4",
                    profession = Profession.DEVELOPER_ANDROID
                ),
                UserEntity(
                    id = 10,
                    fullName = "Josue Lubaki",
                    imageURL = "https://avatars.githubusercontent.com/u/47000000?v=4",
                    profession = Profession.DEVELOPER_ANDROID
                ),
            )
        )
    }
}