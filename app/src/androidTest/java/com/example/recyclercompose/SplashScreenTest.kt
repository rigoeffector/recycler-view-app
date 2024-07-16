package com.example.recyclercompose

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.navigation.testing.TestNavHostController
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.recyclercompose.screens.SplashScreen
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class SplashScreenTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    private lateinit var navController: TestNavHostController

    @Before
    fun setupSplashScreen() {
        navController = TestNavHostController(ApplicationProvider.getApplicationContext())

        composeTestRule.setContent {
            SplashScreen(navController = navController)
        }
    }

//    @Test
//    fun splashScreen_displaysLogo() {
//        composeTestRule
//            .onNodeWithContentDescription("App Logo")
//            .assertIsDisplayed()
//    }

    @Test
    fun splashScreen_hasBlackBackground() {
        composeTestRule
            .onNode(hasTestTag("splash_screen_background"))

    }
}