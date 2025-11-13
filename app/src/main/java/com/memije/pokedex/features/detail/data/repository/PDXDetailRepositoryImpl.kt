package com.memije.pokedex.features.detail.data.repository

import com.memije.pdxcore.network.PDXApiService
import com.memije.pdxcore.network.model.PDXResponseGeneric
import com.memije.pokedex.features.detail.data.mapper.toDomain
import com.memije.pokedex.features.detail.domain.model.PDXDetail
import com.memije.pokedex.features.detail.domain.repository.PDXDetailRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class PDXDetailRepositoryImpl @Inject constructor(
    private val apiService: PDXApiService
) : PDXDetailRepository {

    override suspend fun getPokemonDetail(name: String): PDXResponseGeneric<PDXDetail> {
        return try {
            val response = withContext(Dispatchers.IO) { apiService.getPokemonDetail(name) }
            PDXResponseGeneric.Success(response.toDomain())
        } catch (e: Exception) {
            PDXResponseGeneric.Error(e.localizedMessage ?: "Error al obtener detalles")
        }
    }
}