package com.example.strength4mom.ui.theme.exo

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
            _uiState.update {
                //Valid way to update ExoUiState, same for the second one
                ExoUiState(expanded = false)
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
    fun updateCurrentSet() {
        _uiState.update { currentState ->
            currentState.copy(
                currentSet = currentState.currentSet.inc()
            )
        }
    }
}