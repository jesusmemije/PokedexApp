package com.memije.pokedex.features.pokemonlist.data.mapper

import com.memije.pdxcore.network.response.PokemonDto
import com.memije.pokedex.features.pokemonlist.domain.model.PDXPokemon

fun PokemonDto.toDomain(): PDXPokemon {
    val id = url.split("/").dropLast(1).lastOrNull()
    return PDXPokemon(
        id = id?.toIntOrNull() ?: 0,
        name = name,
        imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/$id.png"
    )
}