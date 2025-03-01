package com.memije.pokedex.features.pokemons.data.repository

import com.memije.pokedex.core.network.ApiService
import com.memije.pokedex.core.utils.Response
import com.memije.pokedex.features.pokemons.data.mapper.toDomain
import com.memije.pokedex.features.pokemons.domain.model.Pokemon
import com.memije.pokedex.features.pokemons.domain.repository.PokemonListRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class PokemonListRepositoryImpl @Inject constructor(
    private val apiService: ApiService
) : PokemonListRepository {

    override suspend fun getPokemonList(): Response<List<Pokemon>> {
        return try {
            val response = withContext(Dispatchers.IO) { apiService.getPokemonList() }
            Response.Success(response.results.map { it.toDomain() })
        } catch (e: Exception) {
            Response.Error(e.localizedMessage ?: "Error desconocido")
        }
    }
}
