package ca.josue_lubaki.teamapp.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

/**
 * created by Josue Lubaki
 * date : 2023-04-08
 * version : 1.0.0
 */

data class Dimension(
    val default : Dp = 0.dp,
    val micro : Dp = 4.dp,
    val small : Dp = 8.dp,
    val medium : Dp = 16.dp,
    val semiLarge : Dp = 20.dp,
    val large : Dp = 24.dp,
    val xlarge : Dp = 32.dp,
    val semiXXLarge : Dp = 36.dp,
    val xxlarge : Dp = 40.dp,
    val xxxlarge : Dp = 48.dp,
    val xxxxlarge : Dp = 56.dp,
    val xxxxxlarge : Dp = 64.dp,

    val paddingMicro : Dp = 10.dp,
    val paddingSmall : Dp = 12.dp,
    val paddingMedium : Dp = 30.dp,
    val paddingLarge : Dp = 40.dp,
    val paddingLargeExtra : Dp = 60.dp,
    val paddingSemiXLarge : Dp = 72.dp,
    val paddingXLarge : Dp = 80.dp,
    val paddingXXLarge : Dp = 96.dp,
    val paddingXXXLarge : Dp = 124.dp,
    val paddingXXXXLarge : Dp = 160.dp,

    val fontSizeDefault : TextUnit = 14.sp,
    val fontSizeSmall : TextUnit = 16.sp,
    val fontSizeMedium : TextUnit = 18.sp,
    val fontSizeLarge : TextUnit = 20.sp,
    val fontSizeXLarge : TextUnit = 22.sp,
    val fontSizeXXLarge : TextUnit = 24.sp,
    val fontSizeXXXLarge : TextUnit = 26.sp,
    val fontSizeXXXXLarge : TextUnit = 28.sp,
    val fontSizeXXXXXLarge : TextUnit = 30.sp,
    val fontSizeMiniLarge : TextUnit = 32.sp,
    val fontSizeExtraLarge : TextUnit = 36.sp,

    val letterSpacingTiny : TextUnit = 0.5.sp,
    val letterSpacingSmall : TextUnit = 1.sp,
    val letterSpacingMedium : TextUnit = 1.5.sp,
    val letterSpacingLarge : TextUnit = 2.sp,

    val borderStrokeDefault : Dp = 0.75.dp,
    val borderStrokeTiny : Dp = 1.dp,
    val borderStrokeSmall : Dp = 2.dp,
    val borderStrokeMedium : Dp = 3.dp,
    val borderStrokeLarge : Dp = 4.dp,

    val buttonWidthSmall : Dp = 200.dp,
    val buttonWidthDefault : Dp = 310.dp,
    val buttonWidthMedium : Dp = 350.dp,

    val textFieldWidthSmall : Dp = 180.dp,
    val textFieldWidthMedium : Dp = 370.dp,
    val textFieldWidthLarge : Dp = 400.dp,

    val bannerHeight : Dp = 220.dp,
    val imageSize : Dp = 160.dp
)


val LocalDimension = compositionLocalOf { Dimension() }
val MaterialTheme.dimensions: Dimension
    @Composable
    @ReadOnlyComposable
    get() = LocalDimension.current