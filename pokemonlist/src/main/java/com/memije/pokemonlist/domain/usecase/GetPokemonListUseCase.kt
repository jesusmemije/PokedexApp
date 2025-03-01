package com.memije.pokemonlist.domain.usecase

import com.memije.pokemonlist.domain.repository.PokemonListRepository
import javax.inject.Inject

class GetPokemonListUseCase @Inject constructor(
    private val repository: PokemonListRepository
) {
    suspend operator fun invoke() = repository.getPokemonList()
}
