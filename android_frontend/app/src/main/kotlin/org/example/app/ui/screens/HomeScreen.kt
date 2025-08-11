package org.example.app.ui.screens

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.example.app.data.Recipe
import org.example.app.data.fakeRecipeList
import org.example.app.ui.widgets.RecipeCard

// PUBLIC_INTERFACE
@Composable
fun HomeScreen(modifier: Modifier = Modifier) {
    val recipes = remember { fakeRecipeList }
    RecipeGrid(recipes = recipes, modifier)
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun RecipeGrid(recipes: List<Recipe>, modifier: Modifier = Modifier) {
    LazyVerticalGrid(
        cells = GridCells.Adaptive(160.dp),
        contentPadding = PaddingValues(8.dp),
        modifier = modifier.fillMaxSize()
    ) {
        items(recipes.size) { idx ->
            RecipeCard(recipe = recipes[idx])
        }
    }
}
