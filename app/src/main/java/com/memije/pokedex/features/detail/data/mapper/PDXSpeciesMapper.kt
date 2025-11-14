package com.memije.pokedex.features.detail.data.mapper

import com.memije.pdxcore.network.response.PDXSpeciesResponse
import com.memije.pokedex.features.detail.domain.model.FlavorList
import com.memije.pokedex.features.detail.domain.model.PDXSpeciesDomainModel
import com.memije.pokedex.features.detail.domain.model.Value

fun PDXSpeciesResponse.toDomain(): PDXSpeciesDomainModel {
    return PDXSpeciesDomainModel(
        flavorTextEntries = flavorTextEntries.map { entry ->
            FlavorList(
                flavorText = entry.flavorText,
                language = Value(
                    name = entry.language.name,
                    url = entry.language.url
                ),
                version = Value(
                    name = entry.version.name,
                    url = entry.version.url
                )
            )
        }
    )
}