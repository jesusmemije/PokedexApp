package com.memije.pdxcore.network.response

import com.google.gson.JsonArray
import com.google.gson.JsonElement
import com.google.gson.annotations.SerializedName

data class PDXSpeciesResponse (
    @SerializedName("base_happiness")
    val baseHappiness: Long,

    @SerializedName("capture_rate")
    val captureRate: Long,

    val color: ValueDto,

    @SerializedName("egg_groups")
    val eggGroups: List<ValueDto>,

    @SerializedName("evolution_chain")
    val evolutionChain: EvolutionChainDto,

    @SerializedName("evolves_from_species")
    val evolvesFromSpecies: JsonElement? = null,

    @SerializedName("flavor_text_entries")
    val flavorTextEntries: List<FlavorTextEntryDto>,

    @SerializedName("form_descriptions")
    val formDescriptions: JsonArray,

    @SerializedName("forms_switchable")
    val formsSwitchable: Boolean,

    @SerializedName("gender_rate")
    val genderRate: Long,

    val genera: List<GenusDto>,
    val generation: ValueDto,

    @SerializedName("growth_rate")
    val growthRate: ValueDto,

    val habitat: ValueDto,

    @SerializedName("has_gender_differences")
    val hasGenderDifferences: Boolean,

    @SerializedName("hatch_counter")
    val hatchCounter: Long,

    val id: Long,

    @SerializedName("is_baby")
    val isBaby: Boolean,

    @SerializedName("is_legendary")
    val isLegendary: Boolean,

    @SerializedName("is_mythical")
    val isMythical: Boolean,

    val name: String,
    val names: List<NameDto>,
    val order: Long,

    @SerializedName("pal_park_encounters")
    val palParkEncounters: List<PalParkEncounterDto>,

    @SerializedName("pokedex_numbers")
    val pokedexNumbers: List<PokedexNumberDto>,

    val shape: ValueDto,
    val varieties: List<VarietyDto>
)

data class ValueDto (
    val name: String,
    val url: String
)

data class EvolutionChainDto (
    val url: String
)

data class FlavorTextEntryDto (
    @SerializedName("flavor_text")
    val flavorText: String,

    val language: ValueDto,
    val version: ValueDto
)

data class GenusDto (
    val genus: String,
    val language: ValueDto
)

data class NameDto (
    val language: ValueDto,
    val name: String
)

data class PalParkEncounterDto (
    val area: ValueDto,

    @SerializedName("base_score")
    val baseScore: Long,

    val rate: Long
)

data class PokedexNumberDto (
    @SerializedName("entry_number")
    val entryNumber: Long,

    val pokedex: ValueDto
)

data class VarietyDto (
    @SerializedName("is_default")
    val isDefault: Boolean,

    val pokemon: ValueDto
)