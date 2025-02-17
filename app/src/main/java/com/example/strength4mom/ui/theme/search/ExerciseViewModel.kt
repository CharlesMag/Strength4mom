package com.example.strength4mom.ui.theme.search

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import com.example.strength4mom.network.Exercise
import com.example.strength4mom.network.RetrofitInstance
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class ExerciseViewModel : ViewModel() {


    // State to store the exercises result
    var exercises = mutableStateOf<List<Exercise>>(emptyList())
        private set

    // Handle the API request
    fun fetchExercises(apiKey: String = "iTK9UnvYXz0/Cj77yQDNIQ==poYEvgXCSZYv0kyN") {
        viewModelScope.launch {
            try {
                val response = RetrofitInstance.apiService.getExercises(apiKey)
                if (response.isSuccessful) {
                    exercises.value = response.body() ?: emptyList()
                }
            } catch (e: Exception) {
                exercises.value = emptyList() // If error occurs, set an empty list
            }
        }
    }
}
