package com.memije.pokedex.features.detail.domain.model

data class PDXSpeciesDomainModel(
    val flavorTextEntries: List<FlavorList>
)

data class FlavorList(
    val flavorText: String,
    val language: Value,
    val version: Value
)

data class Value(
    val name: String,
    val url: String
)