package com.memije.pokemonskills.di

import com.memije.core.network.ApiService
import com.memije.pokemonskills.data.repository.PokemonAbilityRepositoryImpl
import com.memije.pokemonskills.domain.repository.PokemonAbilityRepository
import com.memije.pokemonskills.domain.usecase.GetPokemonAbilityUseCase
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
