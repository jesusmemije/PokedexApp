package com.memije.pokedex.features.pokemonlist.data.repository

import com.memije.pdxcore.network.PDXApiService
import com.memije.pdxcore.network.model.PDXResponseGeneric
import com.memije.pokedex.features.pokemonlist.data.mapper.toDomain
import com.memije.pokedex.features.pokemonlist.domain.model.PDXPokemonDomainModel
import com.memije.pokedex.features.pokemonlist.domain.repository.PDXPokemonListRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.withContext
import javax.inject.Inject

class PDXPokemonListRepositoryImpl @Inject constructor(
    private val apiService: PDXApiService
) : PDXPokemonListRepository {

    override suspend fun getPokemonList(): PDXResponseGeneric<List<PDXPokemonDomainModel>> {
        return withContext(Dispatchers.IO) {
            try {
                val pokemonListResponse = apiService.getPokemonList()
                coroutineScope {
                    val detailedPokemonList = pokemonListResponse.results.map { pokemonResult ->
                        async {
                            val detailResponse = apiService.getPokemonDetail(pokemonResult.name)
                            pokemonResult.toDomain(detailResponse)
                        }
                    }.awaitAll()
                    PDXResponseGeneric.Success(detailedPokemonList)
                }
            } catch (e: Exception) {
                PDXResponseGeneric.Error(e.localizedMessage ?: "Error desconocido")
            }
        }
    }
}
