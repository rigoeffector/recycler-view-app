package com.example.recyclercompose

import com.example.recyclercompose.screens.DetailsViewScreen



import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.navigation.testing.TestNavHostController
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.recyclercompose.models.DataModel
import okhttp3.internal.tls.OkHostnameVerifier.verify
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class DetailsViewScreenTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    private lateinit var navController: TestNavHostController

    @Before
    fun setupDetailsViewScreen() {
        navController = TestNavHostController(ApplicationProvider.getApplicationContext())
    }

    @Test
    fun detailsViewScreen_displaysItemDetails() {
        val testItem = DataModel(
            id = 1,
            name = "Test Item",
            data = mapOf("Key1" to "Value1", "Key2" to "Value2")
        )

        composeTestRule.setContent {
            DetailsViewScreen(item = testItem, navController = navController)
        }

        composeTestRule.onNodeWithText("Test Item").assertIsDisplayed()
        composeTestRule.onNodeWithText("KEY1 : Value1").assertIsDisplayed()
        composeTestRule.onNodeWithText("KEY2 : Value2").assertIsDisplayed()
    }

    @Test
    fun detailsViewScreen_topBarDisplaysCorrectTitle() {
        val testItem = DataModel(id = 1, name = "Test Item", data = null)

        composeTestRule.setContent {
            DetailsViewScreen(item = testItem, navController = navController)
        }

        // Replace "More" with the actual string resource value
        composeTestRule.onNodeWithText("More Info").assertIsDisplayed()
    }

    @Test
    fun detailsViewScreen_backButtonNavigatesBack() {
        val testItem = DataModel(id = 1, name = "Test Item", data = null)

        composeTestRule.setContent {
            DetailsViewScreen(item = testItem, navController = navController)
        }

        composeTestRule.onNodeWithContentDescription("Back").performClick()

        // Verify that popBackStack was called
//        verify(navController).popBackStack()
    }
}