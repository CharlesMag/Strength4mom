package com.example.strength4mom.data

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.example.strength4mom.R

/**
 * A data class to represent the information presented in the exercise card
 */

data class Exo(
    @DrawableRes val imageResourceID: Int,
    @StringRes val name: Int,
    val numberSet: Int,
    val numberRep: Int,
    @StringRes val description: Int,
    val Id: Int,
)

//My listOf exercises to be used by the app

val exos = listOf(
    Exo(R.drawable.gobletsquatstart, R.string.exercise_1, 4,10,R.string.exercise_description_1, 1),
    Exo(R.drawable.singlelegdeadlift, R.string.exercise_2, 5, 10, R.string.exercise_description_2,2),
    Exo(R.drawable.glutebridge, R.string.exercise_3, 4, 15,R.string.exercise_description_3,3)
)