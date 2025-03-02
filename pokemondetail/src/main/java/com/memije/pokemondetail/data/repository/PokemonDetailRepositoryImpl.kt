package com.memije.pokemondetail.data.repository

import com.memije.core.network.ApiService
import com.memije.core.network.model.Response
import com.memije.pokemondetail.data.mapper.toDomain
import com.memije.pokemondetail.domain.model.PokemonDetail
import com.memije.pokemondetail.domain.repository.PokemonDetailRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class PokemonDetailRepositoryImpl @Inject constructor(
    private val apiService: ApiService
) : PokemonDetailRepository {

    override suspend fun getPokemonDetail(name: String): Response<PokemonDetail> {
        return try {
            val response = withContext(Dispatchers.IO) { apiService.getPokemonDetail(name) }
            Response.Success(response.toDomain())
        } catch (e: Exception) {
            Response.Error(e.localizedMessage ?: "Error al obtener detalles")
        }
    }
}