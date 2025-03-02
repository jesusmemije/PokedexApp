package com.memije.pokemondetail.domain.usecase

import com.memije.pokemondetail.domain.model.PokemonDetail
import com.memije.pokemondetail.domain.repository.PokemonDetailRepository
import com.memije.core.network.model.Response
import javax.inject.Inject

class GetPokemonDetailUseCase @Inject constructor(
    private val repository: PokemonDetailRepository
) {
    suspend operator fun invoke(name: String): Response<PokemonDetail> = repository.getPokemonDetail(name)
}