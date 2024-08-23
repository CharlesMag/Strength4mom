package com.example.strength4mom

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
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
                    .padding(dimensionResource(R.dimen.padding_small))
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
                ExoInfo(exoName = exo.name, exoSets = exo.numberSet, exoReps = exo.numberRep)
            }
        }
    }
}

@Composable
fun ExoInfo(
    @StringRes exoName: Int,
    @StringRes exoSets: Int,
    @StringRes exoReps: Int,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
    ) {
        Text(text = "Goblet Squat")
        Row(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Text(text = "Sets: 4")
            Text(text = "Reps: 15")
        }
    }
}

//ExoInfo
//ExoButton
//ExoImage
//ExoDescription