package com.memije.pdxdesignsystem.components.itemcard.model

import androidx.compose.ui.graphics.Color

data class PDXItemPokemonUIModel(
    val id: Int,
    val numberFormat: String,
    val name: String,
    val imageUrl: String,
    val backgroundCard: Color,
    val backgroundPokemon: Color,
    val imagenPokemon: Int,
    val types: List<PokemonTypeUI>,
)

data class PokemonTypeUI(
    val name: String,
    val color: Color,
    val iconRes: Int
)
