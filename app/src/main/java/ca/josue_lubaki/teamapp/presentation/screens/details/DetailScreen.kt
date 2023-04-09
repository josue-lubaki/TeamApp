package ca.josue_lubaki.teamapp.presentation.screens.details

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import ca.josue_lubaki.teamapp.R
import ca.josue_lubaki.teamapp.data.db.local.Profession.*
import ca.josue_lubaki.teamapp.domain.models.UserEntity
import ca.josue_lubaki.teamapp.domain.models.orPlaceholder
import ca.josue_lubaki.teamapp.presentation.components.AppBar
import ca.josue_lubaki.teamapp.presentation.components.ProfileContent
import ca.josue_lubaki.teamapp.presentation.components.ProfilePicture
import ca.josue_lubaki.teamapp.ui.theme.TeamAppTheme
import ca.josue_lubaki.teamapp.ui.theme.dimensions
import ca.josue_lubaki.teamapp.utils.Extension.showPlaceholder
import coil.compose.rememberAsyncImagePainter

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
    val state by viewModel.state.collectAsState()
    val user = remember { mutableStateOf<UserEntity?>(null) }

    LaunchedEffect(key1 = id) {
        viewModel.onGetUserById(id)
    }

    LaunchedEffect(key1 = state){
        when(state){
            is DetailsState.Success -> user.value = (state as DetailsState.Success).user
            else -> Unit
        }
    }

    DetailsScreen(
        state = state,
        user = user.value,
        onBackPressed = onBackPressed
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun DetailsScreen(
    state : DetailsState,
    user: UserEntity?,
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

        val backgroundColor = MaterialTheme.colorScheme.primaryContainer

        Surface(
            modifier = Modifier.fillMaxSize(),
            color = backgroundColor.copy(alpha = 0.1f),
        ) {
            // destructing the user object
            val (_, fullName, imageURL, profession) = user.orPlaceholder()

            Box(modifier = Modifier.fillMaxWidth()) {
                Image(
                    painter = rememberAsyncImagePainter(profession.bannerUrl),
                    contentDescription = stringResource(R.string.banner),
                    modifier = Modifier
                        .fillMaxWidth()
                        .showPlaceholder(visible = state is DetailsState.Loading)
                        .padding(top = paddingValues.calculateTopPadding())
                        .height(MaterialTheme.dimensions.bannerHeight),
                    contentScale = ContentScale.FillBounds
                )

                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(
                            top = paddingValues.calculateTopPadding(),
                            bottom = paddingValues.calculateBottomPadding()
                        )
                        .padding(top = MaterialTheme.dimensions.paddingXXXLarge),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Top
                ) {
                    ProfilePicture(
                        imageURL = imageURL,
                        imageSize = MaterialTheme.dimensions.imageSize,
                        borderColor = backgroundColor,
                        borderSize = MaterialTheme.dimensions.micro,
                        showPlaceholder = state is DetailsState.Loading
                    )
                    ProfileContent(
                        fullName = fullName,
                        profession = profession,
                        horizontalAlignment = Alignment.CenterHorizontally,
                        showPlaceholder = state is DetailsState.Loading
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun DetailsScreenPreview() {
    TeamAppTheme {
        DetailsScreen(
            state = DetailsState.Idle,
            user = UserEntity(
                id = 1,
                fullName = "Josue Lubaki",
                imageURL = "https://avatars.githubusercontent.com/u/16869302?v=4",
                profession = DEVELOPER_ANDROID
            ),
            onBackPressed = {}
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun DetailsScreenShimmerPreview() {
    TeamAppTheme {
        DetailsScreen(
            state = DetailsState.Loading,
            user = null,
            onBackPressed = {}
        )
    }
}