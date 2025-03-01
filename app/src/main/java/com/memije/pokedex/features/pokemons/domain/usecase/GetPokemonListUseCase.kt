package com.memije.pokedex.features.pokemons.domain.usecase

import com.memije.pokedex.features.pokemons.domain.repository.PokemonListRepository
import javax.inject.Inject

class GetPokemonListUseCase @Inject constructor(
    private val repository: PokemonListRepository
) {
    suspend operator fun invoke() = repository.getPokemonList()
}
