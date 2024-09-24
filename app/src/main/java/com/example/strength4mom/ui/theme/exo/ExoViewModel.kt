package com.example.strength4mom.ui.theme.exo

import android.util.Log
import androidx.lifecycle.ViewModel
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
        Log.d("CurrentSet ExoScreen", "CurrentSet: ViewModel ${exoSets}")
        Log.d("CurrentSet ExoScreen", "CurrentSet _ui: exoUiState ${_uiState.value.currentSet}")
        Log.d("CurrentSet ExoScreen", "Update UI_1: ${_uiState.value.exoDone}")

        if (uiState.value.currentSet == exoSets) {
            _uiState.update { currentState ->
                currentState.copy(exoDone = true)
            }
        }
        if (_uiState.value.currentSet > exoSets) {
            resetCurrentSet()
            updateExoCapsule()
        }

    }


    private fun resetCurrentSet() {
        _uiState.update { currentState ->
            currentState.copy(
                currentSet = 0
            )
        }
    }


    private fun updateExoCapsule() {
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



