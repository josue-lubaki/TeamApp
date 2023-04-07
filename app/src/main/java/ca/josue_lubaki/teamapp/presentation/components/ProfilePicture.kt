package ca.josue_lubaki.teamapp.presentation.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import ca.josue_lubaki.teamapp.R
import ca.josue_lubaki.teamapp.ui.theme.TeamAppTheme
import coil.compose.rememberAsyncImagePainter

/**
 * created by Josue Lubaki
 * date : 2023-04-07
 * version : 1.0.0
 */

@Composable
fun ProfilePicture(
    imageURL : String,
    imageSize : Dp = 72.dp
) {
    Card(
        shape = CircleShape,
        border= BorderStroke(
            width = 2.dp,
            color = MaterialTheme.colorScheme.primary,
        ),
        modifier = Modifier.padding(16.dp),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Image(
            painter = rememberAsyncImagePainter(imageURL),
            contentDescription = stringResource(R.string.profile_picture),
            modifier = Modifier.size(imageSize),
            contentScale = ContentScale.Crop,
        )
    }
}

@Preview
@Composable
fun ProfilePicturePreview() {
    TeamAppTheme {
        ProfilePicture(
            imageURL = "https://ca.slack-edge.com/TRR87H161-U03ET6VHNSC-7c824e72f1ce-512"
        )
    }
}