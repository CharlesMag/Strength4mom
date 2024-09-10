package com.example.strength4mom

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.strength4mom.data.Exo
import com.example.strength4mom.data.exos
import com.example.strength4mom.ui.theme.exo.ExoScreenItem
import com.example.strength4mom.ui.theme.exo.ExoViewModel
import com.example.strength4mom.ui.theme.exo.StartAppScreen
import javax.sql.DataSource


@Composable
        /**
         * import androidx.lifecycle.viewmodel.compose.viewModel
         * Also need to add     implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.6.1")
         * in gradle.kts
         * Needed to use viewModel()
         * */
fun StrengthApp(
    viewModel: ExoViewModel = viewModel(),
    navHostController: NavHostController = rememberNavController()
) {
    val viewModel: ExoViewModel = viewModel()

    Scaffold(
        topBar = {Strength4MomTopBar()}
    ) { innerPadding ->
        val uiState by viewModel.uiState.collectAsState()
        NavHost(
            navController = navHostController,
            startDestination = Strength4MomScreen.Start.name,
            modifier = Modifier.padding(innerPadding)
        ) {
           composable(route = Strength4MomScreen.Start.name) {
               StartAppScreen(
                   onStartWorkoutButtonClicked = { navHostController.navigate(Strength4MomScreen.ExoScreen.name) },
                   modifier = Modifier
                       .fillMaxWidth()
                       .padding(dimensionResource(R.dimen.padding_medium))
               )
           }
            composable(route = Strength4MomScreen.ExoScreen.name) {
                LazyColumn {
                    items(exos) {
                        ExoScreenItem(exo = it)
                    }
                }
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

enum class Strength4MomScreen {
    Start,
    ExoScreen,
}