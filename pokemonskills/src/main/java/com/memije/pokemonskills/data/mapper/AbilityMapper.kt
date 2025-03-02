package com.memije.pokemonskills.data.mapper

import com.memije.core.network.response.PokemonAbilityResponse
import com.memije.pokemonskills.domain.model.Ability

fun PokemonAbilityResponse.toDomain(): Ability {
    return Ability(
        id = id,
        name = name,
        effect = effectEntries.firstOrNull { it.language.name == "es" }?.effect ?: "No hay descripción disponible en español"
    )
}