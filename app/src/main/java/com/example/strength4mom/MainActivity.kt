package com.example.strength4mom
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.example.strength4mom.ui.theme.theme.Strength4MomTheme
import com.example.strength4mom.ui.theme.exo.StrengthApp


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



