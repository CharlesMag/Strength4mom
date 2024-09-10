package com.example.strength4mom

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.strength4mom.ui.theme.exo.StrengthApp
import com.example.strength4mom.ui.theme.theme.Strength4MomTheme

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*
import org.junit.Rule

class Strenght4MomUiTests {
    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun CheckTopBarTitle() {
        composeTestRule.setContent {
            Strength4MomTheme {
                StrengthApp()
            }
        }

        composeTestRule.onNodeWithText("Exercise 1").performClick()
        composeTestRule.onNodeWithText("Here goes the description of the exercise").assertIsDisplayed()
    }
}