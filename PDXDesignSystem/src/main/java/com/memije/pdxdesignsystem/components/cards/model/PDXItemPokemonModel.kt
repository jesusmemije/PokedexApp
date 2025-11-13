package com.memije.pdxdesignsystem.components.cards.model

import androidx.compose.ui.graphics.Color

data class PDXItemPokemonModel(
    val id: Int,
    val name: String,
    val imageUrl: String,
    val containerColor: Color,
    val backgroundImage: Color
)