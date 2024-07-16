package com.example.recyclercompose

import ListViewScreen
import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.recyclercompose.models.DataModel
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class ListViewScreenTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun listViewScreen_displaysItems() {
        val testItems = listOf(
            DataModel(1, "Item 1", data = null),
            DataModel(2, "Item 2", data = null),
            DataModel(3, "Item 3", data = null)
        )

        composeTestRule.setContent {
            ListViewScreen(
                items = testItems,
                onItemClick = {},
                isLoading = false
            )
        }

        composeTestRule.onNodeWithText("Item 1").assertIsDisplayed()
        composeTestRule.onNodeWithText("Item 2").assertIsDisplayed()
        composeTestRule.onNodeWithText("Item 3").assertIsDisplayed()
    }

    @Test
    fun listViewScreen_displaysLoadingIndicator() {
        composeTestRule.setContent {
            ListViewScreen(
                items = emptyList(),
                onItemClick = {},
                isLoading = true
            )
        }

    }

    @Test
    fun listViewScreen_itemClick() {
        var clickedItem: DataModel? = null
        val testItems = listOf(DataModel(1, "Test Item", data = null))

        composeTestRule.setContent {
            ListViewScreen(
                items = testItems,
                onItemClick = { clickedItem = it },
                isLoading = false
            )
        }

        composeTestRule.onNodeWithText("Test Item").performClick()
        assert(clickedItem == testItems[0])
    }

    @Test
    fun listViewScreen_displaysTopAppBar() {
        composeTestRule.setContent {
            ListViewScreen(
                items = emptyList(),
                onItemClick = {},
                isLoading = false
            )
        }

        composeTestRule.onNodeWithText("All Items").assertIsDisplayed()
    }
}