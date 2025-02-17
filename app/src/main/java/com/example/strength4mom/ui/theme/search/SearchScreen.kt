package com.example.strength4mom.ui.theme.search

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel


@Composable
fun SearchScreen(
    modifier: Modifier = Modifier
) {
    val exerciseViewModel: ExerciseViewModel = viewModel()
    exerciseViewModel.fetchExercises()
    val exercises = exerciseViewModel.exercises.value

    Card(
        modifier = modifier,
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = modifier
        ) {
            // Display exercises list or a fallback message if no data
            if (exercises.isNotEmpty()) {
                exercises.forEach { exercise ->
                    Text(
                        text = """
                        Name: ${exercise.name}
                        Type: ${exercise.type}
                    """
                    )
                }
            } else {
                // Fallback text if no exercises are found
                Text(text = "No exercises found or error occurred")
            }
        }
    }
}