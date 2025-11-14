package com.memije.pokedex.features.detail.domain.usecase

import com.memije.pdxcore.network.model.PDXResponseGeneric
import com.memije.pokedex.features.detail.domain.model.PDXSpeciesModel
import com.memije.pokedex.features.detail.domain.repository.PDXSpeciesRepository
import javax.inject.Inject

class PDXGetPokemonSpeciesUseCase @Inject constructor(
    private val repository: PDXSpeciesRepository
) {
    suspend operator fun invoke(name: String): PDXResponseGeneric<PDXSpeciesModel> = repository.getPokemonSpecies(name)
}