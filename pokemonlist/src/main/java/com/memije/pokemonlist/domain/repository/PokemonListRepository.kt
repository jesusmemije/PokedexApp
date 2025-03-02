package com.memije.pokemonlist.domain.repository

import com.memije.core.network.model.Response
import com.memije.pokemonlist.domain.model.Pokemon

interface PokemonListRepository {
    suspend fun getPokemonList(): Response<List<Pokemon>>
}
