package com.example.strength4mom

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.Surface
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.strength4mom.ui.theme.theme.Strength4MomTheme


class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Strength4MomTheme {
                val windowSize = calculateWindowSizeClass(this)
                StrengthApp(
                    windowSize = windowSize.widthSizeClass
                )
            }
        }
    }
}





@Preview(showBackground = true)
@Composable
fun StrengthAppPreview() {
    Strength4MomTheme {
        Surface {
            StrengthApp(windowSize = WindowWidthSizeClass.Compact)
        }
    }
}