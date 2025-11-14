package com.memije.pokedex.features.detail.data.repository

import com.memije.pdxcore.network.PDXApiService
import com.memije.pdxcore.network.model.PDXResponseGeneric
import com.memije.pdxcore.utils.constants.PDXAppConstants.ERROR_SERVICE_GENERIC
import com.memije.pokedex.features.detail.data.mapper.toDomain
import com.memije.pokedex.features.detail.domain.model.PDXDetailDomainModel
import com.memije.pokedex.features.detail.domain.repository.PDXDetailRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class PDXDetailRepositoryImpl @Inject constructor(
    private val apiService: PDXApiService
) : PDXDetailRepository {

    override suspend fun getPokemonDetail(name: String): PDXResponseGeneric<PDXDetailDomainModel> {
        return try {
            val response = withContext(Dispatchers.IO) { apiService.getPokemonDetail(name) }
            PDXResponseGeneric.Success(response.toDomain())
        } catch (e: Exception) {
            PDXResponseGeneric.Error(e.localizedMessage ?: ERROR_SERVICE_GENERIC)
        }
    }
}