package com.memije.pokedex.features.pokemonlist.domain.usecase

import com.memije.pokedex.features.pokemonlist.domain.repository.PDXPokemonListRepository
import javax.inject.Inject

class PDXGetPokemonListUseCase @Inject constructor(
    private val repository: PDXPokemonListRepository
) {
    suspend operator fun invoke() = repository.getPokemonList()
}
