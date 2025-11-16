package com.memije.pokedex.features.pokemonlist.presentation.util

import androidx.compose.ui.graphics.Color
import com.memije.pdxdesignsystem.R
import com.memije.pdxdesignsystem.theme.BugColor
import com.memije.pdxdesignsystem.theme.BugLightColor
import com.memije.pdxdesignsystem.theme.DarkColor
import com.memije.pdxdesignsystem.theme.DarkLightColor
import com.memije.pdxdesignsystem.theme.DragonColor
import com.memije.pdxdesignsystem.theme.DragonLightColor
import com.memije.pdxdesignsystem.theme.ElectricColor
import com.memije.pdxdesignsystem.theme.ElectricLightColor
import com.memije.pdxdesignsystem.theme.FairyColor
import com.memije.pdxdesignsystem.theme.FairyLightColor
import com.memije.pdxdesignsystem.theme.FightingColor
import com.memije.pdxdesignsystem.theme.FightingLightColor
import com.memije.pdxdesignsystem.theme.FireColor
import com.memije.pdxdesignsystem.theme.FireLightColor
import com.memije.pdxdesignsystem.theme.FlyingColor
import com.memije.pdxdesignsystem.theme.FlyingLightColor
import com.memije.pdxdesignsystem.theme.GhostColor
import com.memije.pdxdesignsystem.theme.GhostLightColor
import com.memije.pdxdesignsystem.theme.GrassColor
import com.memije.pdxdesignsystem.theme.GrassLightColor
import com.memije.pdxdesignsystem.theme.GroundColor
import com.memije.pdxdesignsystem.theme.GroundLightColor
import com.memije.pdxdesignsystem.theme.IceColor
import com.memije.pdxdesignsystem.theme.IceLightColor
import com.memije.pdxdesignsystem.theme.NormalColor
import com.memije.pdxdesignsystem.theme.NormalLightColor
import com.memije.pdxdesignsystem.theme.PoisonColor
import com.memije.pdxdesignsystem.theme.PoisonLightColor
import com.memije.pdxdesignsystem.theme.PsychicColor
import com.memije.pdxdesignsystem.theme.PsychicLightColor
import com.memije.pdxdesignsystem.theme.RockColor
import com.memije.pdxdesignsystem.theme.RockLightColor
import com.memije.pdxdesignsystem.theme.SteelColor
import com.memije.pdxdesignsystem.theme.SteelLightColor
import com.memije.pdxdesignsystem.theme.WaterColor
import com.memije.pdxdesignsystem.theme.WaterLightColor

data class PokemonListUI(
    val name: String,
    val backgroundCard: Color,
    val backgroundPokemon: Color,
    val imagenPokemonRes: Int
)

val pokemonListUIMap = mapOf(
    "normal" to PokemonListUI(
        name = "Normal",
        backgroundCard = NormalLightColor,
        backgroundPokemon = NormalColor,
        imagenPokemonRes = R.drawable.icon_normal
    ),
    "fire" to PokemonListUI(
        name = "Fuego",
        backgroundCard = FireLightColor,
        backgroundPokemon = FireColor,
        imagenPokemonRes = R.drawable.icon_fire
    ),
    "water" to PokemonListUI(
        name = "Agua",
        backgroundCard = WaterLightColor,
        backgroundPokemon = WaterColor,
        imagenPokemonRes = R.drawable.icon_water
    ),
    "electric" to PokemonListUI(
        name = "Eléctrico",
        backgroundCard = ElectricLightColor,
        backgroundPokemon = ElectricColor,
        imagenPokemonRes = R.drawable.icon_electric
    ),
    "grass" to PokemonListUI(
        name = "Planta",
        backgroundCard = GrassLightColor,
        backgroundPokemon = GrassColor,
        imagenPokemonRes = R.drawable.icon_grass
    ),
    "ice" to PokemonListUI(
        name = "Hielo",
        backgroundCard = IceLightColor,
        backgroundPokemon = IceColor,
        imagenPokemonRes = R.drawable.icon_ice
    ),
    "fighting" to PokemonListUI(
        name = "Lucha",
        backgroundCard = FightingLightColor,
        backgroundPokemon = FightingColor,
        imagenPokemonRes = R.drawable.icon_fighting
    ),
    "poison" to PokemonListUI(
        name = "Veneno",
        backgroundCard = PoisonLightColor,
        backgroundPokemon = PoisonColor,
        imagenPokemonRes = R.drawable.icon_poison
    ),
    "ground" to PokemonListUI(
        name = "Tierra",
        backgroundCard = GroundLightColor,
        backgroundPokemon = GroundColor,
        imagenPokemonRes = R.drawable.icon_ground
    ),
    "flying" to PokemonListUI(
        name = "Volador",
        backgroundCard = FlyingLightColor,
        backgroundPokemon = FlyingColor,
        imagenPokemonRes = R.drawable.icon_flying
    ),
    "psychic" to PokemonListUI(
        name = "Psíquico",
        backgroundCard = PsychicLightColor,
        backgroundPokemon = PsychicColor,
        imagenPokemonRes = R.drawable.icon_psychic
    ),
    "bug" to PokemonListUI(
        name = "Bicho",
        backgroundCard = BugLightColor,
        backgroundPokemon = BugColor,
        imagenPokemonRes = R.drawable.icon_bug
    ),
    "rock" to PokemonListUI(
        name = "Roca",
        backgroundCard = RockLightColor,
        backgroundPokemon = RockColor,
        imagenPokemonRes = R.drawable.icon_rock
    ),
    "ghost" to PokemonListUI(
        name = "Fantasma",
        backgroundCard = GhostLightColor,
        backgroundPokemon = GhostColor,
        imagenPokemonRes = R.drawable.icon_ghost
    ),
    "dragon" to PokemonListUI(
        name = "Dragón",
        backgroundCard = DragonLightColor,
        backgroundPokemon = DragonColor,
        imagenPokemonRes = R.drawable.icon_dragon
    ),
    "dark" to PokemonListUI(
        name = "Siniestro",
        backgroundCard = DarkLightColor,
        backgroundPokemon = DarkColor,
        imagenPokemonRes = R.drawable.icon_dark
    ),
    "steel" to PokemonListUI(
        name = "Acero",
        backgroundCard = SteelLightColor,
        backgroundPokemon = SteelColor,
        imagenPokemonRes = R.drawable.icon_steel
    ),
    "fairy" to PokemonListUI(
        name = "Hada",
        backgroundCard = FairyLightColor,
        backgroundPokemon = FairyColor,
        imagenPokemonRes = R.drawable.icon_fairy
    )
)
