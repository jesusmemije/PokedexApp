package com.memije.pokedex.features.abilities.domain.repository

import com.memije.pokedex.core.utils.Response
import com.memije.pokedex.features.abilities.domain.model.Ability

interface PokemonAbilityRepository {
    suspend fun getPokemonAbility(name: String): Response<Ability>
}