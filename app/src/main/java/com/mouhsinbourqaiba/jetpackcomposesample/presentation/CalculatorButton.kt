package com.mouhsinbourqaiba.jetpackcomposesample.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp

@Composable
fun CalculatorButton(
    action: CalculatorUiAction,
    modifier: Modifier,
    onClick: () -> Unit
) {
    Box(
         modifier = modifier
             .clip(CircleShape)
             .background(
                 when (action.highlightLevel) {
                     HighLightLevel.Neutral -> MaterialTheme.colorScheme.inverseOnSurface
                     HighLightLevel.HighLighted -> MaterialTheme.colorScheme.surfaceVariant
                     HighLightLevel.SemiHighLighted -> MaterialTheme.colorScheme.tertiary
                     HighLightLevel.StronglyHighLighted -> MaterialTheme.colorScheme.primary
                 }
             )
             .clickable {
                 onClick()
             },
        contentAlignment = Alignment.Center
    ) {
        if (action.text != null) {
            Text(
                text = action.text,
                fontSize = 36.sp,
                textAlign = TextAlign.Center,
                color = when(action.highlightLevel) {
                    is HighLightLevel.Neutral -> MaterialTheme.colorScheme.onSurfaceVariant
                    is HighLightLevel.SemiHighLighted -> MaterialTheme.colorScheme.inverseOnSurface
                    is HighLightLevel.HighLighted -> MaterialTheme.colorScheme.tertiary
                    is HighLightLevel.StronglyHighLighted -> MaterialTheme.colorScheme.onPrimary
                }
            )
        }
        else {
            action.content()
        }
    }
}