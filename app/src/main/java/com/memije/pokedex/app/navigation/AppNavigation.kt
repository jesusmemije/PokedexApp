package com.memije.pokedex.app.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.memije.core.utils.Arguments
import com.memije.core.utils.Routes
import com.memije.pokedex.screens.DetailScreen
import com.memije.pokedex.screens.HomeScreen
import com.memije.pokedex.screens.AbilityScreen
import com.memije.pokemondetail.presentation.viewmodel.PokemonDetailViewModel
import com.memije.pokemonlist.presentation.viewmodel.PokemonListViewModel
import com.memije.pokemonability.presentation.viewmodel.PokemonAbilityViewModel

@Composable
fun NavigationGraph(
    navController: NavHostController,
    pokemonViewModel: PokemonListViewModel,
    abilityViewModel: PokemonAbilityViewModel,
    pokemonDetailViewModel: PokemonDetailViewModel
) {
    NavHost(navController, startDestination = Routes.Home.route) {
        composable(Routes.Home.route) {
            HomeScreen(pokemonViewModel, navController)
        }
        composable(
            Routes.Details.route,
            listOf(navArgument(Arguments.POKEMON_NAME.id) { type = NavType.StringType })
        ) { backStackEntry ->
            val pokemonName = backStackEntry.arguments?.getString(Arguments.POKEMON_NAME.id) ?: ""
            DetailScreen(pokemonDetailViewModel, pokemonName, navController)
        }
        composable(
            Routes.Ability.route,
            listOf(navArgument(Arguments.ABILITY_NAME.id) { type = NavType.StringType })
        ) { backStackEntry ->
            val abilityName = backStackEntry.arguments?.getString(Arguments.ABILITY_NAME.id) ?: ""
            AbilityScreen(abilityViewModel, abilityName, navController)
        }
    }
}
