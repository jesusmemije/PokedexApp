package com.memije.pokemonability.domain.usecase

import com.memije.pokemonability.domain.repository.PokemonAbilityRepository
import javax.inject.Inject

class GetPokemonAbilityUseCase @Inject constructor(
    private val repository: PokemonAbilityRepository
) {
    suspend operator fun invoke(name: String) = repository.getPokemonAbility(name)
}
