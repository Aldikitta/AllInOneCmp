package com.aldikitta.feature.dashboard.components

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Movie
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Shop
import androidx.compose.material3.Icon
import androidx.compose.material3.ShapeDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@Composable
fun Grid(
    paddingValues: PaddingValues,
    itemsMenu: List<ItemMenu>
) {
    LazyVerticalGrid(
        columns = GridCells.Adaptive(minSize = 128.dp)
    ) {
        items(itemsMenu) {
            ItemMenu(itemMenu = it, modifier = Modifier.padding(paddingValues).fillMaxSize())
        }
    }
}

@Composable
internal fun ItemMenu(
    itemMenu: ItemMenu,
    modifier: Modifier
) {

    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        Box(
            modifier = Modifier.size(120.dp)
                .border(width = 2.dp, color = Color.Black, shape = ShapeDefaults.Medium)
                .clickable { itemMenu.navigteTo.invoke() },
            contentAlignment = Alignment.Center
        ) {
            Column(
                modifier = Modifier.padding(16.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Icon(itemMenu.icon, contentDescription = "Movie", Modifier.size(50.dp))
                Spacer(Modifier.height(8.dp))
                Text(itemMenu.title, textAlign = TextAlign.Center)
            }
        }
    }
}