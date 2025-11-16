package com.memije.pokedex.features.pokemonlist.domain.repository

import com.memije.pdxcore.network.model.PDXResponseGeneric
import com.memije.pokedex.features.pokemonlist.domain.model.PDXPokemonDomainModel

interface PDXPokemonListRepository {
    suspend fun getPokemonList(): PDXResponseGeneric<List<PDXPokemonDomainModel>>
}
