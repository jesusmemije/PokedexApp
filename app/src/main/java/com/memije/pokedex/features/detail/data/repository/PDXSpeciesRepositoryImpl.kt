package com.memije.pokedex.features.detail.data.repository

import com.memije.pdxcore.network.PDXApiService
import com.memije.pdxcore.network.model.PDXResponseGeneric
import com.memije.pdxcore.utils.constants.PDXAppConstants.ERROR_SERVICE_GENERIC
import com.memije.pokedex.features.detail.data.mapper.toDomain
import com.memije.pokedex.features.detail.domain.model.PDXSpeciesModel
import com.memije.pokedex.features.detail.domain.repository.PDXSpeciesRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class PDXSpeciesRepositoryImpl @Inject constructor(
    private val apiService: PDXApiService
) : PDXSpeciesRepository {

    override suspend fun getPokemonSpecies(name: String): PDXResponseGeneric<PDXSpeciesModel> {
        return try {
            val response = withContext(Dispatchers.IO) { apiService.getPokemonSpecies(name) }
            PDXResponseGeneric.Success(response.toDomain())
        } catch (e: Exception) {
            PDXResponseGeneric.Error(e.localizedMessage ?: ERROR_SERVICE_GENERIC)
        }
    }
}