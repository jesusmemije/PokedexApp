package com.memije.pokedex.features.abilities.data.repository

import android.util.Log
import com.memije.core.network.ApiService
import com.memije.pokedex.features.abilities.data.mapper.toDomain
import com.memije.pokedex.features.abilities.domain.model.Ability
import com.memije.pokedex.features.abilities.domain.repository.PokemonAbilityRepository
import com.memije.core.network.model.Response
import javax.inject.Inject

class PokemonAbilityRepositoryImpl @Inject constructor(
    private val apiService: ApiService
) : PokemonAbilityRepository {

    override suspend fun getPokemonAbility(name: String): Response<Ability> {
        return try {
            val response = apiService.getPokemonAbility(name)

            // DEBUG: Imprimir las traducciones disponibles
            response.effectEntries.forEach { entry ->
                Log.d("AbilityTranslation", "Idioma: ${entry.language.name}, Descripción: ${entry.effect}")
            }

            Response.Success(response.toDomain())
        } catch (e: Exception) {
            Response.Error(e.localizedMessage ?: "Error al obtener detalles de la habilidad")
        }
    }
}
