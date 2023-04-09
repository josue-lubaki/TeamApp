package ca.josue_lubaki.teamapp.presentation.screens.users

import android.util.Log
import androidx.compose.foundation.layout.Column
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
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import ca.josue_lubaki.teamapp.R
import ca.josue_lubaki.teamapp.data.db.local.Profession
import ca.josue_lubaki.teamapp.domain.models.UserEntity
import ca.josue_lubaki.teamapp.domain.models.orPlaceholder
import ca.josue_lubaki.teamapp.presentation.components.AppBar
import ca.josue_lubaki.teamapp.presentation.components.ProfileCard
import ca.josue_lubaki.teamapp.presentation.components.ProfileCardPlaceholder
import ca.josue_lubaki.teamapp.ui.theme.TeamAppTheme
import ca.josue_lubaki.teamapp.ui.theme.dimensions

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
    val state by viewModel.state.collectAsStateWithLifecycle()

    LaunchedEffect(key1 = true){
        viewModel.onGetUsers()
    }

    UserScreen(
        state = state,
        onSelected = onSelected
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UserScreen(
    state : UserState,
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
                .padding(paddingValues)
                .padding(
                    horizontal = MaterialTheme.dimensions.small,
                    vertical = MaterialTheme.dimensions.micro
                ),
            color = MaterialTheme.colorScheme.primaryContainer.copy(alpha = 0.1f)
        ) {
            LazyColumn {
                when(state) {
                    is UserState.Loading -> {
                        items(10) {
                            ProfileCard(showPlaceholder = true)
                        }
                    }

                    is UserState.Success -> {
                        items(
                            items = state.users,
                            key = { userEntity -> userEntity.id }
                        ) { userEntity ->
                            ProfileCard(
                                userEntity = userEntity,
                                onClick = { onSelected(userEntity.id) },
                            )
                        }
                    }

                    else -> Unit
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
            state = UserState.Success(
                listOf(
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
            ),
            onSelected = { },
        )
    }
}