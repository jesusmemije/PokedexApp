package com.memije.pokedex.features.pokemonlist.presentation.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.memije.pdxcore.utils.routes.PDXAppRoutes
import com.memije.pdxdesignsystem.components.cards.ui.PDXItemCardComponent
import com.memije.pdxdesignsystem.theme.GreenMedium
import com.memije.pdxdesignsystem.R
import com.memije.pokedex.features.pokemonlist.domain.model.PDXPokemon
import com.memije.pokedex.features.pokemonlist.presentation.model.toPokemon

@Composable
fun PDXPokemonList(pokemonList: List<PDXPokemon>, navController: NavController) {
    LazyColumn(
        modifier = Modifier.padding(8.dp),
        contentPadding = PaddingValues(8.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
    ) {
        items(pokemonList) { pokemon ->
            PDXItemCardComponent(
                containerColor = GreenMedium,
                backgroundImage = R.drawable.background_grass,
                pokemon = pokemon.toPokemon()
            ) { navController.navigate(PDXAppRoutes.Details.createRoute(pokemon.name)) }
        }
    }
}