package com.memije.pokedex.features.pokemonlist.data.mapper

import com.memije.pdxcore.network.response.PDXDetailResponse
import com.memije.pdxcore.network.response.PokemonDto
import com.memije.pokedex.features.pokemonlist.domain.model.PDXPokemonDomainModel

fun PokemonDto.toDomain(detail: PDXDetailResponse): PDXPokemonDomainModel {
    return PDXPokemonDomainModel(
        id = detail.id,
        name = name,
        imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/${detail.id}.png",
        types = detail.types.map { it.type.name }
    )
}
