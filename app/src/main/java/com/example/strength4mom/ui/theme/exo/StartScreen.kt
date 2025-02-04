package com.example.strength4mom.ui.theme.exo

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.strength4mom.R
import com.example.strength4mom.StrengthApp
import com.example.strength4mom.ui.theme.theme.Strength4MomTheme


@Composable
fun StartAppScreen(
    onStartWorkoutButtonClicked: () -> Unit,
    windowSize: WindowWidthSizeClass,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxHeight(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Button(
            onClick = onStartWorkoutButtonClicked,
        ) {
            Text(
                text = stringResource(R.string.StarterScreenButton)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun StrengthAppPreview() {
    Strength4MomTheme {
        Surface {
            StartAppScreen(
                windowSize = WindowWidthSizeClass.Medium,
                onStartWorkoutButtonClicked = {},
            )
        }
    }
}