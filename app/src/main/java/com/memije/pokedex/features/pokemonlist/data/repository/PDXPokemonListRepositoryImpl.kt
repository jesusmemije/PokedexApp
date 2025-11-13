package com.memije.pokedex.features.pokemonlist.data.repository

import com.memije.pdxcore.network.PDXApiService
import com.memije.pdxcore.network.model.PDXResponseGeneric
import com.memije.pokedex.features.pokemonlist.data.mapper.toDomain
import com.memije.pokedex.features.pokemonlist.domain.model.PDXPokemon
import com.memije.pokedex.features.pokemonlist.domain.repository.PDXPokemonListRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class PDXPokemonListRepositoryImpl @Inject constructor(
    private val apiService: PDXApiService
) : PDXPokemonListRepository {

    override suspend fun getPokemonList(): PDXResponseGeneric<List<PDXPokemon>> {
        return try {
            val response = withContext(Dispatchers.IO) { apiService.getPokemonList() }
            PDXResponseGeneric.Success(response.results.map { it.toDomain() })
        } catch (e: Exception) {
            PDXResponseGeneric.Error(e.localizedMessage ?: "Error desconocido")
        }
    }
}
