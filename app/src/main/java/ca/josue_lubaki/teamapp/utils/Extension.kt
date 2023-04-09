package ca.josue_lubaki.teamapp.utils

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.dp
import com.google.accompanist.placeholder.PlaceholderHighlight
import com.google.accompanist.placeholder.placeholder
import com.google.accompanist.placeholder.shimmer

object Extension {
    @Composable
    fun Modifier.showPlaceholder(
        visible: Boolean = false,
        color : Color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.2f),
        shape: Shape = RoundedCornerShape(16.dp),
        highlightColor: Color = MaterialTheme.colorScheme.surface,
    ) : Modifier = this.then(
        placeholder(
            visible = visible,
            color = color,
            shape = shape,
            highlight = PlaceholderHighlight.shimmer(
                highlightColor = highlightColor,
            ),
        )
    )
}