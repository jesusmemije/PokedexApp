package com.memije.pokedex.features.detail.domain.repository

import com.memije.pdxcore.network.model.PDXResponseGeneric
import com.memije.pokedex.features.detail.domain.model.PDXDetailDomainModel

interface PDXDetailRepository {
    suspend fun getPokemonDetail(name: String): PDXResponseGeneric<PDXDetailDomainModel>
}