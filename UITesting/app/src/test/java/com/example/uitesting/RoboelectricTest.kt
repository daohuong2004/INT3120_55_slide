package com.example.uitesting

import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner

@RunWith(RobolectricTestRunner::class)
class RoboelectricTest {
    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun testButtonClickWithRobolectric() {
        composeTestRule.setContent {
            TestApp()
        }

        composeTestRule.onNodeWithText("test button c:").assertExists()

        composeTestRule.onNodeWithText("test button c:").performClick()

        composeTestRule.onNodeWithText(":c").assertExists()
    }
}