package com.example.strength4mom.ui.theme.exo

import android.graphics.drawable.shapes.Shape
import android.text.method.Touch
import androidx.annotation.StringRes
import androidx.collection.IntIntMap
import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExpandLess
import androidx.compose.material.icons.filled.ExpandMore
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import com.example.strength4mom.data.Exo
import com.example.strength4mom.data.exos
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.strength4mom.R

@Composable
        /**
         * import androidx.lifecycle.viewmodel.compose.viewModel
         * Also need to add     implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.6.1")
         * in gradle.kts
         * Needed to use viewModel()
         * */
fun StrengthApp(
) {
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
 */
@Composable
fun ExoItem(
    exo: Exo,
    exoViewModel: ExoViewModel = viewModel(key = exo.Id.toString()),
    modifier: Modifier = Modifier
) {
    val exoUiState by exoViewModel.uiState.collectAsState()

    Card(
        modifier = modifier
            //Making sure the whole card is clickable to expand
            .clickable(
                onClick = { exoViewModel.updateExpanded() }
            )
    ) {
        Column(modifier = modifier) {
            Row(modifier = modifier) {
                ExoInfo(
                    exoName = exo.name,
                    exoSets = exo.numberSet,
                    exoReps = exo.numberRep,
                    exoImage = exo.imageResourceID,
                    exoDescription = exo.description,
                    id = exo.Id
//                    expanded = exoUiState.expanded,
                )
            }
        }
    }
}

//Composable to add information about the exercise on the card
@Composable
fun ExoInfo(
    @StringRes exoName: Int,
    exoSets: Int,
    exoReps: Int,
    exoImage: Int,
    exoDescription: Int,
    id: Int,
//    expanded: Boolean,
    //Generating a viewModel for each exercise to be able to have an independent expanded
    exoViewModel: ExoViewModel = viewModel(key = id.toString()),
    modifier: Modifier = Modifier
) {
    val exoUiState by exoViewModel.uiState.collectAsState()

    Column(
        modifier = modifier
            .fillMaxWidth()
    ) {
        Text(
            text = stringResource(exoName),
            style = MaterialTheme.typography.displayMedium
        )
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = stringResource(R.string.sets, exoSets),
                style = MaterialTheme.typography.displaySmall,
                modifier = modifier
                    .weight(1f)
            )
            Text(
                text = stringResource(R.string.reps, exoReps),
                style = MaterialTheme.typography.displaySmall,
                modifier = modifier
                    .weight(1f)
            )
            ExoButton(expanded = exoUiState.expanded, onClick = { exoViewModel.updateExpanded() })
        }

        if (exoUiState.expanded) {
            ExoExpanded(
                image = exoImage,
                exoDescription = exoDescription,
                modifier = Modifier)
        }
    }
}

//Icon for expandMore or Less for the exercise displaying additional info if expend = true
//Added Gradle dependency to be able to use icons from https://fonts.google.com/icons
//Added implementation("androidx.compose.material:material-icons-extended") to to :app build.gradle.kts file
@Composable
private fun ExoButton(
    expanded: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    IconButton(
        onClick = onClick,
        modifier = modifier
    ) {
        Icon(
            imageVector = if (!expanded) Icons.Filled.ExpandMore else Icons.Filled.ExpandLess,
            contentDescription = stringResource(R.string.expand_button),
            tint = MaterialTheme.colorScheme.secondary,
        )
    }
}

@Composable
fun ExoExpanded(
    image: Int,
    exoDescription: Int,
    modifier: Modifier
) {
    Image(
        painterResource(image),
        contentDescription = null,
        contentScale = ContentScale.Fit,
        modifier = Modifier
            .padding(dimensionResource(R.dimen.padding_small))
            .clip(MaterialTheme.shapes.small)
    )
    Text(stringResource(exoDescription))
}

ExoButton