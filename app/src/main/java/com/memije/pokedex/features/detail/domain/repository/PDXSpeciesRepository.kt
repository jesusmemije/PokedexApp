package com.memije.pokedex.features.detail.domain.repository

import com.memije.pdxcore.network.model.PDXResponseGeneric
import com.memije.pokedex.features.detail.domain.model.PDXSpeciesDomainModel

interface PDXSpeciesRepository {
    suspend fun getPokemonSpecies(name: String): PDXResponseGeneric<PDXSpeciesDomainModel>
}