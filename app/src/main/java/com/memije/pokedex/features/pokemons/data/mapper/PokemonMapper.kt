package com.memije.pokedex.features.pokemons.data.mapper

import com.memije.pokedex.features.pokemons.data.model.PokemonDto
import com.memije.pokedex.features.pokemons.domain.model.Pokemon

fun PokemonDto.toDomain(): Pokemon {
    val id = url.split("/").dropLast(1).lastOrNull()
    return Pokemon(
        name = name,
        imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/$id.png"
    )
}