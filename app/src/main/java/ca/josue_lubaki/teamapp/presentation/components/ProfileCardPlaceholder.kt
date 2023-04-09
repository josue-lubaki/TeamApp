package ca.josue_lubaki.teamapp.presentation.components


import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ca.josue_lubaki.teamapp.R
import ca.josue_lubaki.teamapp.ui.theme.dimensions
import ca.josue_lubaki.teamapp.utils.Extension.showPlaceholder
import com.google.accompanist.placeholder.PlaceholderHighlight
import com.google.accompanist.placeholder.placeholder
import com.google.accompanist.placeholder.shimmer

/**
 * created by Josue Lubaki
 * date : 2023-04-09
 * version : 1.0.0
 */

@Composable
fun ProfileCardPlaceholder() {
    Card(
        modifier = Modifier
            .padding(all = MaterialTheme.dimensions.small)
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.surface),
        elevation = CardDefaults.cardElevation(MaterialTheme.dimensions.micro),
        border =
        if (!isSystemInDarkTheme())
            BorderStroke(
                width = MaterialTheme.dimensions.borderStrokeDefault,
                color = MaterialTheme.colorScheme.onBackground
            )
        else null,
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start
        ) {

            Card(
                shape = CircleShape,
                border = BorderStroke(
                    width = MaterialTheme.dimensions.borderStrokeSmall,
                    color = MaterialTheme.colorScheme.primary.copy(alpha = 0.2f),
                ),
                modifier = Modifier.padding(MaterialTheme.dimensions.medium),
                elevation = CardDefaults.cardElevation(MaterialTheme.dimensions.micro)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.profile),
                    contentDescription = stringResource(R.string.profile_picture),
                    modifier = Modifier
                        .size(72.dp)
                        .placeholder(
                            visible = true,
                            color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.2f),
                            shape = RoundedCornerShape(16.dp),
                            highlight = PlaceholderHighlight.shimmer(
                                highlightColor = MaterialTheme.colorScheme.surface,
                            ),
                        ),
                    contentScale = ContentScale.Crop,
                )

            }

            Column(
                modifier = Modifier.padding(MaterialTheme.dimensions.small),
                horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.Center
            ) {

                Surface(
                    modifier = Modifier
                        .fillMaxWidth(.5f)
                        .showPlaceholder()
                        .height(MaterialTheme.dimensions.semiLarge),
                    color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.2f),
                    shape = RoundedCornerShape(size = MaterialTheme.dimensions.paddingMicro)
                ) {}
                Spacer(modifier = Modifier.height(MaterialTheme.dimensions.micro))

                Surface(
                    modifier = Modifier
                        .fillMaxWidth(.7f)
                        .showPlaceholder()
                        .height(MaterialTheme.dimensions.semiLarge),
                    color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.2f),
                    shape = RoundedCornerShape(size = MaterialTheme.dimensions.paddingMicro)
                ) {}
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun ProfileCardPlaceholderPreview() {
    ProfileCardPlaceholder()
}