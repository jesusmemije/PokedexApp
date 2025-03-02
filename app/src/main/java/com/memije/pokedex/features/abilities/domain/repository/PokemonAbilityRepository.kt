package com.memije.pokedex.features.abilities.domain.repository

import com.memije.pokedex.features.abilities.domain.model.Ability
import com.memije.core.network.model.Response

interface PokemonAbilityRepository {
    suspend fun getPokemonAbility(name: String): Response<Ability>
}