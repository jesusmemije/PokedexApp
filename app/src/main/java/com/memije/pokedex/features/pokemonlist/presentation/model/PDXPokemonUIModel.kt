package com.memije.pokedex.features.pokemonlist.presentation.model

import androidx.compose.ui.graphics.Color

data class PDXPokemonUIModel(
    val id: Int,
    val name: String,
    val imageUrl: String,
    val types: List<String>
)

data class PokemonListUI(
    val name: String,
    val backgroundCard: Color,
    val backgroundPokemon: Color,
    val imagenPokemonRes: Int
)
