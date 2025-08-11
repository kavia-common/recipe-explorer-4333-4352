package org.example.app.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import org.example.app.data.Recipe
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack

// PUBLIC_INTERFACE
@Composable
fun RecipeDetailScreen(recipe: Recipe, onBack: () -> Unit) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(recipe.title) },
                navigationIcon = {
                    IconButton(onClick = { onBack() }) {
                        Icon(Icons.Filled.ArrowBack, contentDescription = "Back")
                    }
                }
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .verticalScroll(rememberScrollState())
                .fillMaxSize()
        ) {
            AsyncImage(
                model = recipe.imageUrl,
                contentDescription = recipe.title,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(256.dp)
            )
            Spacer(Modifier.height(16.dp))
            Text("Ingredients", style = MaterialTheme.typography.titleMedium, fontWeight = FontWeight.Bold)
            for (ingredient in recipe.ingredients) {
                Text("• $ingredient")
            }
            Spacer(Modifier.height(12.dp))
            Text("Instructions", style = MaterialTheme.typography.titleMedium, fontWeight = FontWeight.Bold)
            for ((step, instruction) in recipe.instructions.withIndex()) {
                Text("${step + 1}. $instruction")
            }
        }
    }
}
