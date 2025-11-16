package com.memije.pokedex.features.pokemonlist.presentation.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.navigation.NavHostController
import com.memije.pdxcore.network.model.PDXResponseGeneric
import com.memije.pdxdesignsystem.screens.PDXErrorScreen
import com.memije.pdxdesignsystem.screens.PDXLoadingScreen
import com.memije.pokedex.features.pokemonlist.presentation.model.PDXPokemonUIModel
import com.memije.pokedex.features.pokemonlist.presentation.viewmodel.PDXPokemonListViewModel

@Composable
fun PDXPokemonListWidget(viewModel: PDXPokemonListViewModel, navController: NavHostController) {

    val pokemonList by viewModel.pokemonList.collectAsState()

    when (pokemonList) {
        is PDXResponseGeneric.Loading -> PDXLoadingScreen()
        is PDXResponseGeneric.Success -> PDXPokemonList(
            (pokemonList as PDXResponseGeneric.Success<List<PDXPokemonUIModel>>).data, navController
        )
        is PDXResponseGeneric.Error -> PDXErrorScreen(message = (pokemonList as PDXResponseGeneric.Error).message) {
            viewModel.getPokemonList()
        }
    }
}
