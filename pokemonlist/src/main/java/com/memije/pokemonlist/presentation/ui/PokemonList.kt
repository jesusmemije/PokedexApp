package com.memije.pokemonlist.presentation.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.memije.core.components.cards.ItemCardListWidget
import com.memije.core.theme.GreenMedium
import com.memije.core.utils.routes.Routes
import com.memije.pokemonlist.R
import com.memije.pokemonlist.domain.model.Pokemon
import com.memije.pokemonlist.presentation.model.toPokemon

@Composable
fun PokemonList(pokemonList: List<Pokemon>, navController: NavController) {
    LazyColumn(
        modifier = Modifier.padding(8.dp),
        contentPadding = PaddingValues(8.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
    ) {
        items(pokemonList) { pokemon ->
            ItemCardListWidget(
                containerColor = GreenMedium,
                backgroundImage = R.drawable.background_grass,
                pokemon = pokemon.toPokemon()
            ) { navController.navigate(Routes.Details.createRoute(pokemon.name)) }
        }
    }
}