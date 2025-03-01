package com.memije.pokedex.features.details.domain.repository

import com.memije.pokedex.features.details.domain.model.PokemonDetail
import com.memije.pokedexgeneric.utils.Response

interface PokemonDetailRepository {
    suspend fun getPokemonDetail(name: String): Response<PokemonDetail>
}