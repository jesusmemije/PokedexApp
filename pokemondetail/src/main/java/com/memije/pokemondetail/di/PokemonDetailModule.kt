package com.memije.pokemondetail.di

import com.memije.core.network.ApiService
import com.memije.pokemondetail.data.repository.PokemonDetailRepositoryImpl
import com.memije.pokemondetail.domain.repository.PokemonDetailRepository
import com.memije.pokemondetail.domain.usecase.GetPokemonDetailUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object PokemonDetailModule {

    @Provides
    fun providePokemonDetailRepository(apiService: ApiService): PokemonDetailRepository {
        return PokemonDetailRepositoryImpl(apiService)
    }

    @Provides
    fun provideGetPokemonDetailUseCase(repository: PokemonDetailRepository): GetPokemonDetailUseCase {
        return GetPokemonDetailUseCase(repository)
    }
}