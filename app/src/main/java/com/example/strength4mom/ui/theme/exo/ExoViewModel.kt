package com.example.strength4mom.ui.theme.exo

import androidx.lifecycle.ViewModel
import com.example.strength4mom.data.exos
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

    fun updateCurrentSet(exoSets: Int) {
        if (_uiState.value.currentSet < exoSets) {

            _uiState.update { currentState ->
                currentState.copy(
                    currentSet = currentState.currentSet.inc()
                )
            }
        } else {
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
//TODO Try to pass exoSets when equals to currentSet, just change the exoDone value
    private fun updateExoCapsule() {
        if (uiState.value.exoDone) {
            _uiState.update {
                ExoUiState(exoDone = false)
            }
        } else {
            _uiState.update { currentState ->
                currentState.copy(
                    exoDone = true
                )
            }
        }
    }
}



