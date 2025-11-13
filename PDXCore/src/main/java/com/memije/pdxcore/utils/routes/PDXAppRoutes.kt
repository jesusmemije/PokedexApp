package com.memije.pdxcore.utils.routes

sealed class PDXAppRoutes(val route: String) {
    data object Home : PDXAppRoutes("home")
    data object Details : PDXAppRoutes("details/{pokemon_name}") {
        fun createRoute(pokemonName: String) = "details/$pokemonName"
    }
    data object Ability : PDXAppRoutes("ability/{ability_name}") {
        fun createRoute(abilityName: String) = "ability/$abilityName"
    }
}