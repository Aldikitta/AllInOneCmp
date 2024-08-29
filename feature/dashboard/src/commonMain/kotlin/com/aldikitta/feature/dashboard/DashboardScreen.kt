package com.aldikitta.feature.dashboard

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Movie
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Shop
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.ShapeDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DashboardScreen(
    navigateToMovie: () -> Unit,
    navigateToEcommerce: () -> Unit,
    navigateToCmpPlayground: () -> Unit
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text("Dashboard")
                }
            )
        }
    ) {
        ItemMenu(
            paddingValues = it,
            navigateToMovie = navigateToMovie,
            navigateToEcommerce = navigateToEcommerce,
            navigateToCmpPlayground = navigateToCmpPlayground
        )
    }
}

@Composable
fun ItemMenu(
    paddingValues: PaddingValues,
    navigateToMovie: () -> Unit,
    navigateToEcommerce: () -> Unit,
    navigateToCmpPlayground: () -> Unit
) {
    Column(
        modifier = Modifier.padding(paddingValues).fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        Box(
            modifier = Modifier.size(120.dp)
                .border(width = 2.dp, color = Color.Black, shape = ShapeDefaults.Medium)
                .clickable { navigateToMovie.invoke() },
            contentAlignment = Alignment.Center
        ) {
            Column(
                modifier = Modifier.padding(16.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Icon(Icons.Filled.Movie, contentDescription = "Movie", Modifier.size(50.dp))
                Spacer(Modifier.height(8.dp))
                Text("Movie")
            }
        }

        Box(
            modifier = Modifier.size(120.dp)
                .border(width = 2.dp, color = Color.Black, shape = ShapeDefaults.Medium)
                .clickable { navigateToEcommerce.invoke() },
            contentAlignment = Alignment.Center
        ) {
            Column(
                modifier = Modifier.padding(16.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Icon(Icons.Filled.Shop, contentDescription = "Shop", Modifier.size(50.dp))
                Spacer(Modifier.height(8.dp))
                Text("E-Commerce")
            }
        }

        Box(
            modifier = Modifier.size(120.dp)
                .border(width = 2.dp, color = Color.Black, shape = ShapeDefaults.Medium)
                .clickable { navigateToCmpPlayground.invoke() },
            contentAlignment = Alignment.Center
        ) {
            Column(
                modifier = Modifier.padding(16.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Icon(Icons.Filled.Settings, contentDescription = "Settings", Modifier.size(50.dp))
                Spacer(Modifier.height(8.dp))
                Text("CMP Playground", textAlign = TextAlign.Center)
            }
        }
    }
}