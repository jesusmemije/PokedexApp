package com.memije.pokedex.features.detail.data.mapper

import com.memije.pdxcore.network.response.PDXDetailResponse
import com.memije.pokedex.features.detail.domain.model.PDXDetailDomainModel

fun PDXDetailResponse.toDomain(): PDXDetailDomainModel {
    return PDXDetailDomainModel(
        id = id,
        name = name,
        imageUrl = sprites.frontImage,
        height = height,
        weight = weight,
        types = types.map { it.type.name },
        abilities = abilities.map { it.ability.name }
    )
}
