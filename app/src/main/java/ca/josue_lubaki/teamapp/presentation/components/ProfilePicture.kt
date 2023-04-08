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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import ca.josue_lubaki.teamapp.R
import ca.josue_lubaki.teamapp.ui.theme.TeamAppTheme
import ca.josue_lubaki.teamapp.ui.theme.dimensions
import coil.compose.rememberAsyncImagePainter

/**
 * created by Josue Lubaki
 * date : 2023-04-07
 * version : 1.0.0
 */

@Composable
fun ProfilePicture(
    imageURL: String,
    imageSize: Dp = MaterialTheme.dimensions.paddingSemiXLarge,
    borderSize: Dp = MaterialTheme.dimensions.borderStrokeSmall,
    borderColor: Color = MaterialTheme.colorScheme.primary
) {
    Card(
        shape = CircleShape,
        border = BorderStroke(
            width = borderSize,
            color = borderColor,
        ),
        modifier = Modifier.padding(MaterialTheme.dimensions.medium),
        elevation = CardDefaults.cardElevation(MaterialTheme.dimensions.micro)
    ) {
        Image(
            painter =
                if (imageURL.isNotEmpty())
                    rememberAsyncImagePainter(imageURL)
                else painterResource(R.drawable.profile),
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