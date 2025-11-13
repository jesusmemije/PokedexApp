package com.memije.pokedex.features.detail.domain.usecase

import com.memije.pdxcore.network.model.PDXResponseGeneric
import com.memije.pokedex.features.detail.domain.model.PDXDetail
import com.memije.pokedex.features.detail.domain.repository.PDXDetailRepository
import javax.inject.Inject

class PDXGetPokemonDetailUseCase @Inject constructor(
    private val repository: PDXDetailRepository
) {
    suspend operator fun invoke(name: String): PDXResponseGeneric<PDXDetail> = repository.getPokemonDetail(name)
}