package com.memije.pokedex.features.details.data.repository

import com.memije.core.network.ApiService
import com.memije.pokedex.features.details.data.mapper.toDomain
import com.memije.pokedex.features.details.domain.model.PokemonDetail
import com.memije.pokedex.features.details.domain.repository.PokemonDetailRepository
import com.memije.core.network.model.Response
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