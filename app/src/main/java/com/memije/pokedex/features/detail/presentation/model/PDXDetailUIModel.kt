package com.memije.pokedex.features.detail.presentation.model

import com.memije.pdxdesignsystem.util.PokemonTypeUI

data class PDXDetailUIModel(
    val id: Int,
    val numberFormat: String,
    val name: String,
    val imageUrl: String,
    val height: Int,
    val weight: Int,
    val pokemonDetailUI: PokemonDetailUI,
    val types: List<PokemonTypeUI>,
    val abilities: List<String>
)

data class PokemonDetailUI(
    val iconImageRes: Int,
    val backgroundImageRes: Int
)
