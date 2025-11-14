package com.memije.pokedex.features.detail.domain.model

data class PDXDetailModel(
    val id: Int,
    val name: String,
    val imageUrl: String,
    val height: Int,
    val weight: Int,
    val types: List<String>,
    val abilities: List<String>
)
