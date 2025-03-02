package com.memije.core.utils

sealed class Routes(val route: String) {
    data object PokemonList : Routes("pokemon_list")
    data object PokemonDetail : Routes("pokemon_detail/{pokemon_name}") {
        fun createRoute(pokemonName: String) = "pokemon_detail/$pokemonName"
    }
    data object AbilityDetail : Routes("ability_detail/{ability_name}") {
        fun createRoute(abilityName: String) = "ability_detail/$abilityName"
    }
}