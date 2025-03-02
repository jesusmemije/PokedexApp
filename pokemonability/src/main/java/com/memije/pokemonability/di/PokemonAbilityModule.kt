package com.memije.pokemonability.di

import com.memije.core.network.ApiService
import com.memije.pokemonability.data.repository.PokemonAbilityRepositoryImpl
import com.memije.pokemonability.domain.repository.PokemonAbilityRepository
import com.memije.pokemonability.domain.usecase.GetPokemonAbilityUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object PokemonAbilityModule {

    @Provides
    fun providePokemonAbilityRepository(apiService: ApiService): PokemonAbilityRepository {
        return PokemonAbilityRepositoryImpl(apiService)
    }

    @Provides
    fun provideGetPokemonAbilityUseCase(repository: PokemonAbilityRepository): GetPokemonAbilityUseCase {
        return GetPokemonAbilityUseCase(repository)
    }
}
