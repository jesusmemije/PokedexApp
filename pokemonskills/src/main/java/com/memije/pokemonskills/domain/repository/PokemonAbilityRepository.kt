package com.memije.pokemonskills.domain.repository

import com.memije.pokemonskills.domain.model.Ability
import com.memije.core.network.model.Response

interface PokemonAbilityRepository {
    suspend fun getPokemonAbility(name: String): Response<Ability>
}