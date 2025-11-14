package com.memije.pdxcore.network.response

import com.google.gson.annotations.SerializedName

data class PDXAbilitiesResponse(
    @SerializedName("id") val id: Int,
    @SerializedName("name") val name: String,
    @SerializedName("effect_entries") val effectEntries: List<EffectEntryDto>
)

data class EffectEntryDto(
    @SerializedName("effect") val effect: String,
    @SerializedName("language") val language: LanguageDto
)

data class LanguageDto(
    @SerializedName("name") val name: String
)