package com.memije.pokedex.features.pokemonlist.domain.model

data class PDXPokemonDomainModel(
    val id: Int,
    val name: String,
    val imageUrl: String,
    val types: List<String>
)
