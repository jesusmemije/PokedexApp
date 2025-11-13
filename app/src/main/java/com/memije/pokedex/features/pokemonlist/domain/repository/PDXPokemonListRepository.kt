package com.memije.pokedex.features.pokemonlist.domain.repository

import com.memije.pdxcore.network.model.PDXResponseGeneric
import com.memije.pokedex.features.pokemonlist.domain.model.PDXPokemon

interface PDXPokemonListRepository {
    suspend fun getPokemonList(): PDXResponseGeneric<List<PDXPokemon>>
}
