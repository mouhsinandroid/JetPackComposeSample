package com.mouhsinbourqaiba.jetpackcomposesample.presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.mouhsinbourqaiba.jetpackcomposesample.domain.CalculatorAction
import com.mouhsinbourqaiba.jetpackcomposesample.domain.ExpressionWriter

class CalculatorViewModel(
    private val writer: ExpressionWriter = ExpressionWriter()
): ViewModel() {
    var expression by mutableStateOf("")

    fun onAction(action: CalculatorAction) {
        writer.processAction(action)
        this.expression = writer.expression
    }

}