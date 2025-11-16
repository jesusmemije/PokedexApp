package com.memije.pokedex.features.pokemonlist.presentation.mapper

import com.memije.pdxcore.utils.extensions.capitalizeFirstLetter
import com.memije.pdxcore.utils.extensions.toFormatNumber
import com.memije.pdxdesignsystem.R
import com.memije.pdxdesignsystem.components.itemcard.model.PDXItemPokemonUIModel
import com.memije.pdxdesignsystem.theme.GrassColor
import com.memije.pdxdesignsystem.theme.GrassLightColor
import com.memije.pdxdesignsystem.util.pokemonTypeUIMap
import com.memije.pokedex.features.pokemonlist.domain.model.PDXPokemonDomainModel
import com.memije.pokedex.features.pokemonlist.presentation.model.PDXPokemonUIModel
import com.memije.pokedex.features.pokemonlist.presentation.util.pokemonListUIMap

fun List<PDXPokemonDomainModel>.toUI(): List<PDXPokemonUIModel> {
    return this.map { pokemon ->
        PDXPokemonUIModel(
            id = pokemon.id,
            name = pokemon.name.capitalizeFirstLetter(),
            imageUrl = pokemon.imageUrl,
            types = pokemon.types
        )
    }
}

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
