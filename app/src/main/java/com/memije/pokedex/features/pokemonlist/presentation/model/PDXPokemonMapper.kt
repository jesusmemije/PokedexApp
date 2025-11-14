package com.memije.pokedex.features.pokemonlist.presentation.model

import com.memije.pdxcore.utils.extensions.capitalizeFirstLetter
import com.memije.pdxcore.utils.extensions.toFormatNumber
import com.memije.pdxdesignsystem.components.itemcard.model.PDXItemPokemonModel
import com.memije.pdxdesignsystem.theme.GreenLight
import com.memije.pdxdesignsystem.theme.GreenMedium
import com.memije.pokedex.features.pokemonlist.domain.model.PDXPokemon

fun PDXPokemon.toPokemon() : PDXItemPokemonModel {
    return PDXItemPokemonModel(
        id = id,
        numberFormat = id.toFormatNumber(),
        name = name.capitalizeFirstLetter(),
        imageUrl = imageUrl,
        containerColor = GreenLight,
        backgroundImage = GreenMedium
    )
}