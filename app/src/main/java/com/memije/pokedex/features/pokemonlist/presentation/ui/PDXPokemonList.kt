package com.memije.pokedex.features.pokemonlist.presentation.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.memije.pdxcore.utils.routes.PDXAppRoutes
import com.memije.pdxdesignsystem.R
import com.memije.pdxdesignsystem.components.itemcard.ui.PDXItemCardComponent
import com.memije.pdxdesignsystem.theme.GreenMedium
import com.memije.pdxdesignsystem.theme.MediumSpacing
import com.memije.pdxdesignsystem.theme.PokedexAppTheme
import com.memije.pdxdesignsystem.theme.SmallSpacing
import com.memije.pokedex.features.pokemonlist.domain.model.PDXPokemon
import com.memije.pokedex.features.pokemonlist.presentation.model.toPokemon

@Composable
fun PDXPokemonList(pokemonList: List<PDXPokemon>, navController: NavController) {
    LazyColumn(
        modifier = Modifier.padding(SmallSpacing),
        contentPadding = PaddingValues(SmallSpacing),
        verticalArrangement = Arrangement.spacedBy(MediumSpacing),
    ) {
        items(pokemonList) { pokemon ->
            PDXItemCardComponent(
                containerColor = GreenMedium,
                backgroundImage = R.drawable.icon_grass,
                pokemon = pokemon.toPokemon()
            ) { navController.navigate(PDXAppRoutes.Details.createRoute(pokemon.name)) }
        }
    }
}

object MockData {
    val samplePokemonList = listOf(
        PDXPokemon(id = 1, name = "Bulbasaur", imageUrl = "https://pngimg.com/uploads/pokemon/pokemon_PNG125.png"),
        PDXPokemon(id = 2, name = "Charmander", imageUrl = "https://pngimg.com/uploads/pokemon/pokemon_PNG125.png"),
        PDXPokemon(id = 3, name = "Squirtle", imageUrl = "https://pngimg.com/uploads/pokemon/pokemon_PNG125.png")
    )
}

@Preview(showBackground = true, name = "Pokemon List Preview", showSystemUi = true)
@Composable
fun PDXPokemonListPreview() {
    PokedexAppTheme {
        Box(modifier = Modifier.systemBarsPadding()) {
            PDXPokemonList(
                pokemonList = MockData.samplePokemonList,
                navController = rememberNavController()
            )
        }
    }
}