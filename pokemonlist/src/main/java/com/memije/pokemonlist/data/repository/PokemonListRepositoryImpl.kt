package com.memije.pokemonlist.data.repository

import com.memije.core.network.ApiService
import com.memije.core.network.model.Response
import com.memije.pokemonlist.data.mapper.toDomain
import com.memije.pokemonlist.domain.model.Pokemon
import com.memije.pokemonlist.domain.repository.PokemonListRepository
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
