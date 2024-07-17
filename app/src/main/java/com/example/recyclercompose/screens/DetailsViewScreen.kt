package com.example.recyclercompose.screens

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.recyclercompose.models.DataModel
import com.example.recyclercompose.ui.theme.ampersand

@Composable
fun DetailsViewScreen(item: DataModel, navController: NavController) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = stringResource(id = com.example.recyclercompose.R.string.more), style = MaterialTheme.typography.h5, color = ampersand) },
                navigationIcon = {
                    IconButton(
                        onClick = { navController.popBackStack() },
                    ) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Back", tint = ampersand)
                    }
                },
                backgroundColor = MaterialTheme.colors.primary,
                elevation = AppBarDefaults.TopAppBarElevation
            )
        }
    ) { paddingValues ->
        Box(
            modifier = Modifier
                .padding(paddingValues)
                .padding(16.dp)
        ) {
            Column(
                modifier = Modifier
                    .wrapContentHeight()
                    .fillMaxWidth()
                    .border(1.dp, Color.Gray, RoundedCornerShape(10.dp))
                    .padding(16.dp)
            ) {
                Text(text = item.name, style = MaterialTheme.typography.h4)
                Spacer(modifier = Modifier.height(8.dp))
                Divider(color = Color.Gray, thickness = 1.dp)
                Spacer(modifier = Modifier.height(8.dp))
                item.data?.forEach { (key, value) ->
                    Text(
                        text = buildAnnotatedString {
                            withStyle(style = SpanStyle(
                                color = ampersand,
                                fontWeight = FontWeight.Bold,
                                fontSize = 18.sp // Adjust this value as needed
                            )) {
                                append(key.uppercase())
                            }
                            append(" : $value")
                        },
                        style = MaterialTheme.typography.body1
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                }
            }
        }
    }
}