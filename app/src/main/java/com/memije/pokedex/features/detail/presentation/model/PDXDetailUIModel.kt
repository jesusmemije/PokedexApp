package com.memije.pokedex.features.detail.presentation.model

import androidx.compose.ui.graphics.Color
import com.memije.pdxcore.utils.extensions.capitalizeFirstLetter
import com.memije.pdxcore.utils.extensions.toFormatNumber
import com.memije.pdxdesignsystem.R
import com.memije.pokedex.features.detail.domain.model.PDXDetailDomainModel
import com.memije.pokedex.features.detail.presentation.util.pokemonDetailUIMap
import com.memije.pokedex.features.detail.presentation.util.pokemonTypeUIMap

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

data class PokemonTypeUI(
    val name: String,
    val color: Color,
    val iconRes: Int
)

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


