package com.memije.pokedex.features.pokemonlist.presentation.mapper

import com.memije.pdxcore.utils.extensions.toFormatNumber
import com.memije.pdxdesignsystem.R
import com.memije.pdxdesignsystem.components.itemcard.model.PDXItemPokemonUIModel
import com.memije.pdxdesignsystem.theme.GrassColor
import com.memije.pdxdesignsystem.theme.GrassLightColor
import com.memije.pokedex.features.pokemonlist.presentation.model.PDXPokemonUIModel
import com.memije.pokedex.features.pokemonlist.presentation.util.pokemonListUIMap
import com.memije.pokedex.features.pokemonlist.presentation.util.pokemonTypeUIMap

fun PDXPokemonUIModel.toItemPokemonUI(): PDXItemPokemonUIModel {

    val primaryType = types.firstOrNull()?.lowercase()
    val typeUI = pokemonListUIMap[primaryType]

    return PDXItemPokemonUIModel(
        id = id,
        numberFormat = id.toFormatNumber(),
        name = name,
        imageUrl = imageUrl,
        backgroundCard = typeUI?.backgroundCard ?: GrassLightColor,
        backgroundPokemon = typeUI?.backgroundPokemon ?: GrassColor,
        imagenPokemon = typeUI?.imagenPokemonRes ?: R.drawable.ic_circle_grass,
        types = types.mapNotNull { type ->
            pokemonTypeUIMap[type]
        }
    )
}
