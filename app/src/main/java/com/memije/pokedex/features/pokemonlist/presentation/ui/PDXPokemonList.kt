package com.memije.pokedex.features.pokemonlist.presentation.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.memije.pdxcore.utils.routes.PDXAppRoutes
import com.memije.pdxdesignsystem.components.itemcard.ui.PDXItemCardComponent
import com.memije.pdxdesignsystem.theme.MediumSpacing
import com.memije.pdxdesignsystem.theme.SmallSpacing
import com.memije.pokedex.features.pokemonlist.presentation.mapper.toItemPokemonUI
import com.memije.pokedex.features.pokemonlist.presentation.model.PDXPokemonUIModel

@Composable
fun PDXPokemonList(pokemonList: List<PDXPokemonUIModel>, navController: NavController) {
    LazyColumn(
        modifier = Modifier.padding(SmallSpacing),
        contentPadding = PaddingValues(SmallSpacing),
        verticalArrangement = Arrangement.spacedBy(MediumSpacing),
    ) {
        items(pokemonList) { pokemon ->
            PDXItemCardComponent(
                pokemon = pokemon.toItemPokemonUI()
            ) { navController.navigate(PDXAppRoutes.Details.createRoute(pokemon.name)) }
        }
    }
}