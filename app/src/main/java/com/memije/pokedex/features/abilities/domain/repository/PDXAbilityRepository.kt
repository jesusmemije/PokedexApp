package com.memije.pokedex.features.abilities.domain.repository

import com.memije.pdxcore.network.model.PDXResponseGeneric
import com.memije.pokedex.features.abilities.domain.model.PDXAbility

interface PDXAbilityRepository {
    suspend fun getPokemonAbility(name: String): PDXResponseGeneric<PDXAbility>
}