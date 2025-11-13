package com.memije.pokedex.features.pokemonlist.presentation.model

import com.memije.pdxdesignsystem.components.cards.model.PDXItemPokemonModel
import com.memije.pdxdesignsystem.theme.GreenLight
import com.memije.pdxdesignsystem.theme.GreenMedium
import com.memije.pokedex.features.pokemonlist.domain.model.PDXPokemon

fun PDXPokemon.toPokemon() : PDXItemPokemonModel {
    return PDXItemPokemonModel(
        id = this.id,
        name = this.name,
        imageUrl = this.imageUrl,
        containerColor = GreenLight,
        backgroundImage = GreenMedium
    )
}