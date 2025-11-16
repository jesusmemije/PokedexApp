package com.memije.pokedex.features.pokemonlist.presentation.util

import com.memije.pdxdesignsystem.R
import com.memije.pdxdesignsystem.components.itemcard.model.PokemonTypeUI
import com.memije.pdxdesignsystem.theme.BugColor
import com.memije.pdxdesignsystem.theme.DarkColor
import com.memije.pdxdesignsystem.theme.DragonColor
import com.memije.pdxdesignsystem.theme.ElectricColor
import com.memije.pdxdesignsystem.theme.FairyColor
import com.memije.pdxdesignsystem.theme.FightingColor
import com.memije.pdxdesignsystem.theme.FireColor
import com.memije.pdxdesignsystem.theme.FlyingColor
import com.memije.pdxdesignsystem.theme.GhostColor
import com.memije.pdxdesignsystem.theme.GrassColor
import com.memije.pdxdesignsystem.theme.GroundColor
import com.memije.pdxdesignsystem.theme.IceColor
import com.memije.pdxdesignsystem.theme.NormalColor
import com.memije.pdxdesignsystem.theme.PoisonColor
import com.memije.pdxdesignsystem.theme.PsychicColor
import com.memije.pdxdesignsystem.theme.RockColor
import com.memije.pdxdesignsystem.theme.SteelColor
import com.memije.pdxdesignsystem.theme.WaterColor

val pokemonTypeUIMap = mapOf(
    "normal" to PokemonTypeUI(
        name = "Normal",
        color = NormalColor,
        iconRes = R.drawable.ic_circle_normal
    ),
    "fire" to PokemonTypeUI(
        name = "Fuego",
        color = FireColor,
        iconRes = R.drawable.ic_circle_fire
    ),
    "water" to PokemonTypeUI(
        name = "Agua",
        color = WaterColor,
        iconRes = R.drawable.ic_circle_water
    ),
    "electric" to PokemonTypeUI(
        name = "Eléctrico",
        color = ElectricColor,
        iconRes = R.drawable.ic_circle_electric
    ),
    "grass" to PokemonTypeUI(
        name = "Planta",
        color = GrassColor,
        iconRes = R.drawable.ic_circle_grass
    ),
    "ice" to PokemonTypeUI(
        name = "Hielo",
        color = IceColor,
        iconRes = R.drawable.ic_circle_ice
    ),
    "fighting" to PokemonTypeUI(
        name = "Lucha",
        color = FightingColor,
        iconRes = R.drawable.ic_circle_fighting
    ),
    "poison" to PokemonTypeUI(
        name = "Veneno",
        color = PoisonColor,
        iconRes = R.drawable.ic_circle_poison
    ),
    "ground" to PokemonTypeUI(
        name = "Tierra",
        color = GroundColor,
        iconRes = R.drawable.ic_circle_ground
    ),
    "flying" to PokemonTypeUI(
        name = "Volador",
        color = FlyingColor,
        iconRes = R.drawable.ic_circle_flying
    ),
    "psychic" to PokemonTypeUI(
        name = "Psíquico",
        color = PsychicColor,
        iconRes = R.drawable.ic_circle_psychic
    ),
    "bug" to PokemonTypeUI(
        name = "Bicho",
        color = BugColor,
        iconRes = R.drawable.ic_circle_bug
    ),
    "rock" to PokemonTypeUI(
        name = "Roca",
        color = RockColor,
        iconRes = R.drawable.ic_circle_rock
    ),
    "ghost" to PokemonTypeUI(
        name = "Fantasma",
        color = GhostColor,
        iconRes = R.drawable.ic_circle_ghost
    ),
    "dragon" to PokemonTypeUI(
        name = "Dragón",
        color = DragonColor,
        iconRes = R.drawable.ic_circle_dragon
    ),
    "dark" to PokemonTypeUI(
        name = "Siniestro",
        color = DarkColor,
        iconRes = R.drawable.ic_circle_dark
    ),
    "steel" to PokemonTypeUI(
        name = "Acero",
        color = SteelColor,
        iconRes = R.drawable.ic_circle_steel
    ),
    "fairy" to PokemonTypeUI(
        name = "Hada",
        color = FairyColor,
        iconRes = R.drawable.ic_circle_fairy
    )
)