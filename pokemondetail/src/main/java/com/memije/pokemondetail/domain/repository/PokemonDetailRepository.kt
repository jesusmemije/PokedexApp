package com.memije.pokemondetail.domain.repository

import com.memije.pokemondetail.domain.model.PokemonDetail
import com.memije.core.network.model.Response

interface PokemonDetailRepository {
    suspend fun getPokemonDetail(name: String): Response<PokemonDetail>
}