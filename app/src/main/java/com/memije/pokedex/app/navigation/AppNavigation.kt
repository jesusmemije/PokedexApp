package com.memije.pokedex.app.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.memije.core.utils.Arguments
import com.memije.core.utils.Routes
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
    NavHost(navController, startDestination = Routes.PokemonList.route) {
        composable(Routes.PokemonList.route) {
            PokemonList(viewModel = pokemonViewModel, navController = navController)
        }
        composable(
            Routes.PokemonDetail.route,
            listOf(navArgument(Arguments.POKEMON_NAME.id) { type = NavType.StringType })
        ) { backStackEntry ->
            val pokemonName = backStackEntry.arguments?.getString(Arguments.POKEMON_NAME.id) ?: ""
            PokemonDetail(
                viewModel = pokemonDetailViewModel,
                pokemonName = pokemonName,
                navController = navController
            )
        }
        composable(
            Routes.AbilityDetail.route,
            listOf(navArgument(Arguments.ABILITY_NAME.id) { type = NavType.StringType })
        ) { backStackEntry ->
            val abilityName = backStackEntry.arguments?.getString(Arguments.ABILITY_NAME.id) ?: ""
            PokemonAbilities(
                viewModel = abilityViewModel,
                abilityName = abilityName,
                navController = navController
            )
        }
    }
}
