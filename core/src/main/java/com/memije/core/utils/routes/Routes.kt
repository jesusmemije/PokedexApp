package com.memije.core.utils.routes

sealed class Routes(val route: String) {
    data object Home : Routes("home")
    data object Details : Routes("details/{pokemon_name}") {
        fun createRoute(pokemonName: String) = "details/$pokemonName"
    }
    data object Ability : Routes("ability/{ability_name}") {
        fun createRoute(abilityName: String) = "ability/$abilityName"
    }
}