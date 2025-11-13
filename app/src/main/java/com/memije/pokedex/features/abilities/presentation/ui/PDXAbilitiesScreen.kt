package com.memije.pokedex.features.abilities.presentation.ui

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.memije.pokedex.features.abilities.presentation.viewmodel.PDXAbilityViewModel

@Composable
fun PDXAbilitiesScreen(
    abilityViewModel: PDXAbilityViewModel,
    abilityName: String,
    navController: NavHostController
) {
    PDXAbilitiesWidget(abilityViewModel, abilityName, navController)
}