package com.memije.pdxdesignsystem.components.itemcard.model

import androidx.compose.ui.graphics.Color
import com.memije.pdxdesignsystem.util.PokemonTypeUI

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
