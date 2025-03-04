package com.memije.pokemonlist.presentation.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.navigation.NavHostController
import com.memije.core.components.ErrorState
import com.memije.core.components.LoadingState
import com.memije.core.network.model.Response
import com.memije.pokemonlist.domain.model.Pokemon
import com.memije.pokemonlist.presentation.viewmodel.PokemonListViewModel

@Composable
fun PokemonListWidget(viewModel: PokemonListViewModel, navController: NavHostController) {

    val pokemonList by viewModel.pokemonList.collectAsState()

    when (pokemonList) {
        is Response.Loading -> LoadingState()
        is Response.Success -> PokemonList(
            (pokemonList as Response.Success<List<Pokemon>>).data, navController
        )
        is Response.Error -> ErrorState(message = (pokemonList as Response.Error).message) {
            viewModel.getPokemonList()
        }
    }
}
