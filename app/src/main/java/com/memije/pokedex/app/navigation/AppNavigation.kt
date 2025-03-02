package com.memije.pokedex.app.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.memije.pokemonskills.presentation.ui.PokemonAbilities
import com.memije.pokemonskills.presentation.viewmodel.PokemonAbilityViewModel
import com.memije.pokemondetail.presentation.ui.PokemonDetail
import com.memije.pokemondetail.presentation.viewmodel.PokemonDetailViewModel
import com.memije.pokemonlist.presentation.ui.PokemonList
import com.memije.pokemonlist.presentation.viewmodel.PokemonListViewModel

@Composable
fun NavigationGraph(
    navController: NavHostController,
    pokemonViewModel: PokemonListViewModel,
    abilityViewModel: PokemonAbilityViewModel,
    pokemonDetailViewModel: PokemonDetailViewModel
) {
    NavHost(navController, startDestination = "pokemonList") {
        composable("pokemonList") {
            PokemonList(viewModel = pokemonViewModel, navController = navController)
        }
        composable("pokemonDetail/{pokemonName}") { backStackEntry ->
            val pokemonName = backStackEntry.arguments?.getString("pokemonName") ?: ""
            PokemonDetail(
                viewModel = pokemonDetailViewModel,
                pokemonName = pokemonName,
                navController = navController
            )
        }
        composable("pokemonAbility/{abilityName}") { backStackEntry ->
            val abilityName = backStackEntry.arguments?.getString("abilityName") ?: ""
            PokemonAbilities(
                viewModel = abilityViewModel,
                abilityName = abilityName,
                navController = navController
            )
        }
    }
}
