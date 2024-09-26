package com.example.strength4mom.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

class ExoItem {
    data class Exo(
        @DrawableRes val imageResourceID: Int,
        @StringRes val name: Int,
        val numberSet: Int,
        val numberRep: Int,
        @StringRes val description: Int,
        val Id: Int,
    )
}