package com.memije.pokedex.features.pokemons.domain.repository

import com.memije.pokedex.core.utils.Response
import com.memije.pokedex.features.pokemons.domain.model.Pokemon

interface PokemonListRepository {
    suspend fun getPokemonList(): Response<List<Pokemon>>
}
