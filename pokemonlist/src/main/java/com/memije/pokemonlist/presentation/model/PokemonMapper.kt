package com.memije.pokemonlist.presentation.model

import com.memije.core.model.PokemonCoreModel
import com.memije.core.theme.GreenLight
import com.memije.core.theme.GreenMedium
import com.memije.pokemonlist.domain.model.Pokemon

fun Pokemon.toPokemon() : PokemonCoreModel {
    return PokemonCoreModel(
        id = this.id,
        name = this.name,
        imageUrl = this.imageUrl,
        containerColor = GreenLight,
        backgroundImage = GreenMedium
    )
}