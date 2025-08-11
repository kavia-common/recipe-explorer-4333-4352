package org.example.app.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.dp
import org.example.app.data.Recipe
import org.example.app.data.fakeRecipeList // Placeholder for demo
import org.example.app.ui.widgets.RecipeCard

// PUBLIC_INTERFACE
@Composable
fun FavoritesScreen(modifier: Modifier = Modifier) {
    // Placeholder: Replace with persistent favorite list logic
    val favorites = remember { fakeRecipeList.take(2) }
    if (favorites.isEmpty()) {
        Box(modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            Text("No favorites yet.")
        }
    } else {
        Column(modifier = modifier.fillMaxSize().padding(8.dp)) {
            Text("Favorite Recipes", style = MaterialTheme.typography.titleLarge)
            Spacer(modifier = Modifier.height(8.dp))
            favorites.forEach { recipe ->
                RecipeCard(recipe = recipe)
            }
        }
    }
}
