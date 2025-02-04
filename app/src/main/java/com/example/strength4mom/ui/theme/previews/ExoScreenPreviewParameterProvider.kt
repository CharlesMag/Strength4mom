package com.example.strength4mom.ui.theme.previews

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.example.strength4mom.R
import com.example.strength4mom.data.local.DataSourceExercises
import com.example.strength4mom.data.local.DataSourceExercises.exos
import com.example.strength4mom.model.ExoItem

object ExoPreviewObject {
    val exoPreviewObject = (
        ExoItem.Exo(
            imageResourceID = R.drawable.gobletsquatstart,
            name = R.string.exercise_1,
            numberSet = 5,
            numberRep = 12,
            description = R.string.exercise_description_1,
            Id = 1,
        )
    )
}