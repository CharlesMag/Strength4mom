package com.example.strength4mom

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.strength4mom.data.Exo
import com.example.strength4mom.data.exos
import com.example.strength4mom.ui.theme.Strength4MomTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Strength4MomTheme {
                Scaffold(
                    topBar = {

                    },
                    modifier = Modifier.fillMaxSize()
                ) { innerPadding ->
                    StrengthApp()
                }
            }
        }
    }
}

@Composable
fun StrengthApp() {
    LazyColumn() {
        items(exos) {
            ExoItem(
                exo = it,
                modifier = Modifier
            )
        }
    }
}


/**
 * Composable displaying the list of exercises with the image and information
 *
 */
@Composable
fun ExoItem(
    exo: Exo,
    modifier: Modifier = Modifier
) {
    Card(modifier = modifier) {
        Column(modifier = modifier) {
            Row(modifier = modifier) {
                Text(text = "Test")
            }
        }
    }
}