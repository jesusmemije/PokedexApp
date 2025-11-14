package com.memije.pokedex.features.detail.presentation.ui

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.memije.pokedex.features.detail.presentation.viewmodel.PDXDetailViewModel

@Composable
fun PDXDetailScreen(
    pokemonDetailViewModel: PDXDetailViewModel,
    pokemonName: String,
    navController: NavHostController
) {
    PDXDetailWidget(pokemonDetailViewModel, pokemonName, navController)
}