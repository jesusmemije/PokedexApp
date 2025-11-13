package com.memije.pokedex.features.abilities.domain.usecase

import com.memije.pokedex.features.abilities.domain.repository.PDXAbilityRepository
import javax.inject.Inject

class PDXGetPokemonAbilitiesUseCase @Inject constructor(
    private val repository: PDXAbilityRepository
) {
    suspend operator fun invoke(name: String) = repository.getPokemonAbility(name)
}
