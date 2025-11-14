package com.memije.pokedex.app.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.memije.pdxcore.utils.routes.PDXArgumentsEnum
import com.memije.pdxcore.utils.routes.PDXAppRoutes
import com.memije.pokedex.features.detail.presentation.ui.PDXDetailScreen
import com.memije.pokedex.features.pokemonlist.presentation.ui.PDXHomeScreen
import com.memije.pokedex.features.abilities.presentation.ui.PDXAbilitiesScreen
import com.memije.pokedex.features.abilities.presentation.viewmodel.PDXAbilityViewModel
import com.memije.pokedex.features.detail.presentation.viewmodel.PDXDetailViewModel
import com.memije.pokedex.features.pokemonlist.presentation.viewmodel.PDXPokemonListViewModel

@Composable
fun PDXNavigationGraph(
    navController: NavHostController,
    pokemonViewModel: PDXPokemonListViewModel,
    abilityViewModel: PDXAbilityViewModel,
    pokemonDetailViewModel: PDXDetailViewModel
) {
    NavHost(navController, startDestination = PDXAppRoutes.Home.route) {
        composable(PDXAppRoutes.Home.route) {
            PDXHomeScreen(pokemonViewModel, navController)
        }
        composable(
            PDXAppRoutes.Details.route,
            listOf(navArgument(PDXArgumentsEnum.POKEMON_NAME.id) { type = NavType.StringType })
        ) { backStackEntry ->
            val pokemonName = backStackEntry.arguments?.getString(PDXArgumentsEnum.POKEMON_NAME.id) ?: ""
            PDXDetailScreen(pokemonDetailViewModel, pokemonName, navController)
        }
        composable(
            PDXAppRoutes.Ability.route,
            listOf(navArgument(PDXArgumentsEnum.ABILITY_NAME.id) { type = NavType.StringType })
        ) { backStackEntry ->
            val abilityName = backStackEntry.arguments?.getString(PDXArgumentsEnum.ABILITY_NAME.id) ?: ""
            PDXAbilitiesScreen(abilityViewModel, abilityName, navController)
        }
    }
}
