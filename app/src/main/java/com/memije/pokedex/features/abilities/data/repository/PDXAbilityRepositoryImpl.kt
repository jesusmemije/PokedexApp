package com.memije.pokedex.features.abilities.data.repository

import android.util.Log
import com.memije.pdxcore.network.PDXApiService
import com.memije.pdxcore.network.model.PDXResponseGeneric
import com.memije.pokedex.features.abilities.data.mapper.toDomain
import com.memije.pokedex.features.abilities.domain.model.PDXAbility
import com.memije.pokedex.features.abilities.domain.repository.PDXAbilityRepository
import javax.inject.Inject

class PDXAbilityRepositoryImpl @Inject constructor(
    private val apiService: PDXApiService
) : PDXAbilityRepository {

    override suspend fun getPokemonAbility(name: String): PDXResponseGeneric<PDXAbility> {
        return try {
            val response = apiService.getPokemonAbility(name)

            // DEBUG: Imprimir las traducciones disponibles
            response.effectEntries.forEach { entry ->
                Log.d("AbilityTranslation", "Idioma: ${entry.language.name}, Descripción: ${entry.effect}")
            }

            PDXResponseGeneric.Success(response.toDomain())
        } catch (e: Exception) {
            PDXResponseGeneric.Error(e.localizedMessage ?: "Error al obtener detalles de la habilidad")
        }
    }
}
