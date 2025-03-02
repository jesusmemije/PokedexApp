package com.memije.pokemonability.domain.repository

import com.memije.pokemonability.domain.model.Ability
import com.memije.core.network.model.Response

interface PokemonAbilityRepository {
    suspend fun getPokemonAbility(name: String): Response<Ability>
}