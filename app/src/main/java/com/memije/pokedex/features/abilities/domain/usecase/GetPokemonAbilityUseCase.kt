package com.memije.pokedex.features.abilities.domain.usecase

import com.memije.pokedex.features.abilities.domain.repository.PokemonAbilityRepository
import javax.inject.Inject

class GetPokemonAbilityUseCase @Inject constructor(
    private val repository: PokemonAbilityRepository
) {
    suspend operator fun invoke(name: String) = repository.getPokemonAbility(name)
}
