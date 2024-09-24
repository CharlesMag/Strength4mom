package com.example.strength4mom.ui.theme.exo

import android.app.Activity
import android.util.Log
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class ExoViewModel : ViewModel() {
    //Exo UI state

    private val _uiState = MutableStateFlow(ExoUiState())
    val uiState: StateFlow<ExoUiState> = _uiState.asStateFlow()

    fun updateExpanded() {
        if (uiState.value.expanded) {
            _uiState.update { currentState ->
                currentState.copy(
                    expanded = false
                )
            }
        } else {
            //Very common way to update the UiState
            _uiState.update { currentState ->
                currentState.copy(
                    expanded = true
                )
            }
        }
    }

    fun updateCurrentSet(exoSets: Int) {
        if (uiState.value.currentSet <= exoSets) {
            _uiState.update { currentState ->
                currentState.copy(
                    currentSet = currentState.currentSet.inc()
                )
            }
        }

        if (uiState.value.currentSet == exoSets) {
            _uiState.update { currentState ->
                currentState.copy(exoDone = true)
            }
        }
    }

    fun decreaseCurrentSet() {
        _uiState.update { currentState ->
            currentState.copy(
                currentSet = currentState.currentSet.dec()
            )
        }
    }

    fun resetCurrentSet() {
        _uiState.update { currentState ->
            currentState.copy(
                currentSet = 0
            )
        }
    }

    fun updateExoCapsule() {
        if (!uiState.value.exoDone) {
            _uiState.update { currentState ->
                currentState.copy(
                    exoDone = true
                )
            }
        } else {
            _uiState.update { currentState ->
                currentState.copy(
                    exoDone = false
                )
            }
        }
    }
}

