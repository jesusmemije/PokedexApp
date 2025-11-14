package com.memije.pokedex.features.abilities.data.mapper

import com.memije.pdxcore.network.response.PDXAbilitiesResponse
import com.memije.pokedex.features.abilities.domain.model.PDXAbility

fun PDXAbilitiesResponse.toDomain(): PDXAbility {
    return PDXAbility(
        id = id,
        name = name,
        effect = effectEntries.firstOrNull { it.language.name == "en" }?.effect ?: "No hay descripción disponible en inglés"
    )
}