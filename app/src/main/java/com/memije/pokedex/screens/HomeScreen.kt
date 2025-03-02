package com.memije.pokedex.screens

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.memije.pokemonlist.presentation.ui.PokemonList
import com.memije.pokemonlist.presentation.viewmodel.PokemonListViewModel

@Composable
fun HomeScreen(pokemonViewModel: PokemonListViewModel, navController: NavHostController) {
    PokemonList(pokemonViewModel, navController)
}