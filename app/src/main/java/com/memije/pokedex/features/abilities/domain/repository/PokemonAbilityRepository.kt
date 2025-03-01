package com.memije.pokedex.features.abilities.domain.repository

import com.memije.pokedex.features.abilities.domain.model.Ability
import com.memije.pokedexgeneric.utils.Response

interface PokemonAbilityRepository {
    suspend fun getPokemonAbility(name: String): Response<Ability>
}