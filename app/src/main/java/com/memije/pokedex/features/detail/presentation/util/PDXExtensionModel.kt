package com.memije.pokedex.features.detail.presentation.util

import com.memije.pokedex.features.detail.domain.model.FlavorList

fun List<FlavorList>.getFlavorTextEs(): String? {
    return this.firstOrNull { it.language.name == "es" }?.flavorText
}