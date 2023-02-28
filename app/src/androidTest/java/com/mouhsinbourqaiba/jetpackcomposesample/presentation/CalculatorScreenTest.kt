package com.mouhsinbourqaiba.jetpackcomposesample.presentation


import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import com.mouhsinbourqaiba.jetpackcomposesample.MainActivity
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class CalculatorScreenTest {

    @get:Rule
    val composeRule = createAndroidComposeRule(MainActivity::class.java)
    lateinit var viewModel: CalculatorViewModel

    @Before
    fun setUp() {
        viewModel = CalculatorViewModel()
    }

    @Test
    fun interExpression_correctResultDisplayed() {
        composeRule.onNodeWithText("1").performClick()
        composeRule.onNodeWithText("+").performClick()
        composeRule.onNodeWithText("1").performClick()
        composeRule.onNodeWithText("=").performClick()

        composeRule.onNodeWithText("2.0").assertIsDisplayed()

    }
}