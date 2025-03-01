package com.memije.core.response

import com.google.gson.annotations.SerializedName

data class PokemonListResponse(
    @SerializedName("results") val results: List<PokemonDto>
)

data class PokemonDto(
    @SerializedName("name") val name: String,
    @SerializedName("url") val url: String
)