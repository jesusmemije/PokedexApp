package com.memije.pdxcore.network.response

import com.google.gson.annotations.SerializedName

data class PDXDetailResponse(
    @SerializedName("id") val id: Int,
    @SerializedName("name") val name: String,
    @SerializedName("sprites") val sprites: SpritesDto,
    @SerializedName("height") val height: Int,
    @SerializedName("weight") val weight: Int,
    @SerializedName("types") val types: List<TypeWrapperDto>,
    @SerializedName("abilities") val abilities: List<AbilityDto>
)

data class SpritesDto(
    @SerializedName("front_default") val frontImage: String
)

data class TypeWrapperDto(
    @SerializedName("type") val type: TypeDto
)

data class TypeDto(
    @SerializedName("name") val name: String
)

data class AbilityDto(
    @SerializedName("ability") val ability: SpeciesDto
)

data class SpeciesDto (
    val name: String
)