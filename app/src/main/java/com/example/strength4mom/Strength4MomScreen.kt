package com.example.strength4mom

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.strength4mom.data.exos
import com.example.strength4mom.ui.theme.exo.ExoItem


@Composable
        /**
         * import androidx.lifecycle.viewmodel.compose.viewModel
         * Also need to add     implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.6.1")
         * in gradle.kts
         * Needed to use viewModel()
         * */
fun StrengthApp() {
    Scaffold(
        topBar = {
            Strength4MomTopBar()
        }
    ) { innerPadding ->
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
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Strength4MomTopBar(modifier: Modifier = Modifier) {
    CenterAlignedTopAppBar(
        title = {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = stringResource(id = R.string.app_name),
                    style = MaterialTheme.typography.displayLarge
                )
            }
        },
        modifier = Modifier
    )
}