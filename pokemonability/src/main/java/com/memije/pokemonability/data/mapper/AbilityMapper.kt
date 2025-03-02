package com.memije.pokemonability.data.mapper

import com.memije.core.network.response.PokemonAbilityResponse
import com.memije.pokemonability.domain.model.Ability

fun PokemonAbilityResponse.toDomain(): Ability {
    return Ability(
        id = id,
        name = name,
        effect = effectEntries.firstOrNull { it.language.name == "en" }?.effect ?: "No hay descripción disponible en inglés"
    )
}