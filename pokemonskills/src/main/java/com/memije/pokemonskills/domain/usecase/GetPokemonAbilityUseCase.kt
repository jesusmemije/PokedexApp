package com.memije.pokemonskills.domain.usecase

import com.memije.pokemonskills.domain.repository.PokemonAbilityRepository
import javax.inject.Inject

class GetPokemonAbilityUseCase @Inject constructor(
    private val repository: PokemonAbilityRepository
) {
    suspend operator fun invoke(name: String) = repository.getPokemonAbility(name)
}
