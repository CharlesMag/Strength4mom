package com.example.strength4mom.data

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.example.strength4mom.R

/**
 * A data class to represent the information presented in the exercise card
 */

data class Exo(
    @DrawableRes val imageResourceID1: Int,
    @DrawableRes val imageResourceID2: Int,
    @StringRes val name: Int,
    val numberSet: Int,
    val numberRep: Int,
    @StringRes val description: Int
)

val exos = listOf(
    Exo(1,2, R.string.exercise_1, 4,10,R.string.exercise_description_1)
)