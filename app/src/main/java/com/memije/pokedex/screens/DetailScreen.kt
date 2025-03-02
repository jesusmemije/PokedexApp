package com.memije.pokedex.screens

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.memije.pokemondetail.presentation.ui.PokemonDetail
import com.memije.pokemondetail.presentation.viewmodel.PokemonDetailViewModel

@Composable
fun DetailScreen(
    pokemonDetailViewModel: PokemonDetailViewModel,
    pokemonName: String,
    navController: NavHostController
) {
    PokemonDetail(pokemonDetailViewModel, pokemonName, navController)
}