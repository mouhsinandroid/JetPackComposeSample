package com.mouhsinbourqaiba.jetpackcomposesample.presentation

import androidx.compose.runtime.Composable
import com.mouhsinbourqaiba.jetpackcomposesample.domain.CalculatorAction

data class CalculatorUiAction(
    val text: String?,
    val highlightLevel: HighLightLevel,
    val action: CalculatorAction,
    val content: @Composable () -> Unit = {}
)

sealed interface HighLightLevel {
    object Neutral: HighLightLevel
    object SemiHighLighted : HighLightLevel
    object HighLighted: HighLightLevel
    object StronglyHighLighted: HighLightLevel
}