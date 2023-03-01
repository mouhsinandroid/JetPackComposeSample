package com.mouhsinbourqaiba.jetpackcomposesample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.mouhsinbourqaiba.jetpackcomposesample.presentation.CalculatorScreen
import com.mouhsinbourqaiba.jetpackcomposesample.ui.theme.MaterialCalculatorTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Constants.BASE_URL
        setContent {
          MaterialCalculatorTheme{
              CalculatorScreen()
          }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MaterialCalculatorTheme{
        CalculatorScreen()
    }
}