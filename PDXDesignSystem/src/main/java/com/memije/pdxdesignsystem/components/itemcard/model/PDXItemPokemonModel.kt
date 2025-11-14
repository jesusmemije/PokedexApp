package com.memije.pdxdesignsystem.components.itemcard.model

import androidx.compose.ui.graphics.Color

data class PDXItemPokemonModel(
    val id: Int,
    val numberFormat: String,
    val name: String,
    val imageUrl: String,
    val containerColor: Color,
    val backgroundImage: Color
)