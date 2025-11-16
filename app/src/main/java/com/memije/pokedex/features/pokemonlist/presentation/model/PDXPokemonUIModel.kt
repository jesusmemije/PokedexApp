package com.memije.pokedex.features.pokemonlist.presentation.model

import com.memije.pdxcore.utils.extensions.capitalizeFirstLetter
import com.memije.pokedex.features.pokemonlist.domain.model.PDXPokemonDomainModel

data class PDXPokemonUIModel(
    val id: Int,
    val name: String,
    val imageUrl: String,
    val types: List<String>
)

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
