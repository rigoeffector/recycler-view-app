package com.example.recyclercompose.navigation

import ListViewScreen
import LoadingIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.recyclercompose.screens.DetailsViewScreen
import com.example.recyclercompose.viewmodel.DataViewModel

@Composable
fun NavGraph(navController: NavHostController) {
    val viewModel: DataViewModel = viewModel()

    NavHost(navController = navController, startDestination = "listViewScreen") {

        composable("listViewScreen") {
            val dataState = viewModel.data.collectAsState()
            val isLoading = viewModel.isLoading.collectAsState()

            val data = dataState.value
            val loading = isLoading.value

            if (loading && data.isEmpty()) {
                LoadingIndicator()
            } else {
                ListViewScreen(
                    items = data,
                    onItemClick = { item ->
                        navController.navigate("detailsScreen/${item.id}")
                    },
                    isLoading = loading
                )
            }
        }
        composable("detailsScreen/{itemId}") { backStackEntry ->
            val itemId = backStackEntry.arguments?.getString("itemId")
            val item = viewModel.getItemById(itemId!!)
            item?.let {
                DetailsViewScreen(item = it,navController)
            }
        }
    }
}
