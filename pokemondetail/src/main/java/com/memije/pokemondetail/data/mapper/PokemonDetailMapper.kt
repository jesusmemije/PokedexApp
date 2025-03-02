package com.memije.pokemondetail.data.mapper

import com.memije.core.network.response.PokemonDetailResponse
import com.memije.pokemondetail.domain.model.PokemonDetail

fun PokemonDetailResponse.toDomain(): PokemonDetail {
    return PokemonDetail(
        id = id,
        name = name,
        imageUrl = sprites.frontImage,
        height = height,
        weight = weight,
        types = types.map { it.type.name },
        abilities = abilities.map { it.ability.name }
    )
}
