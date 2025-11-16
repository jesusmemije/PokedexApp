package com.memije.pokedex.features.detail.presentation.mapper

import com.memije.pdxcore.utils.extensions.capitalizeFirstLetter
import com.memije.pdxcore.utils.extensions.toFormatNumber
import com.memije.pdxdesignsystem.R
import com.memije.pdxdesignsystem.util.pokemonTypeUIMap
import com.memije.pokedex.features.detail.domain.model.PDXDetailDomainModel
import com.memije.pokedex.features.detail.presentation.model.PDXDetailUIModel
import com.memije.pokedex.features.detail.presentation.model.PokemonDetailUI
import com.memije.pokedex.features.detail.presentation.util.pokemonDetailUIMap
import kotlin.collections.get

fun PDXDetailDomainModel.toUI(): PDXDetailUIModel {
    return PDXDetailUIModel(
        id = id,
        numberFormat = id.toFormatNumber(),
        name = name.capitalizeFirstLetter(),
        imageUrl = imageUrl,
        height = height,
        weight = weight,
        pokemonDetailUI = pokemonDetailUIMap[types.firstOrNull()] ?: PokemonDetailUI(
            iconImageRes = R.drawable.icon_fire,
            backgroundImageRes = R.drawable.shape_rounded_botton_fire
        ),
        types = types.mapNotNull { type ->
            pokemonTypeUIMap[type]
        },
        abilities = abilities
    )
}