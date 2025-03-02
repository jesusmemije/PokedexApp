package com.memije.pokedex.screens

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.memije.pokemonability.presentation.ui.PokemonAbility
import com.memije.pokemonability.presentation.viewmodel.PokemonAbilityViewModel

@Composable
fun AbilityScreen(
    abilityViewModel: PokemonAbilityViewModel,
    abilityName: String,
    navController: NavHostController
) {
    PokemonAbility(abilityViewModel, abilityName, navController)
}