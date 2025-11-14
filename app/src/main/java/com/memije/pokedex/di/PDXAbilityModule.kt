package com.memije.pokedex.di

import com.memije.pdxcore.network.PDXApiService
import com.memije.pokedex.features.abilities.data.repository.PDXAbilityRepositoryImpl
import com.memije.pokedex.features.abilities.domain.repository.PDXAbilityRepository
import com.memije.pokedex.features.abilities.domain.usecase.PDXGetPokemonAbilitiesUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object PDXAbilityModule {

    @Provides
    fun providePokemonAbilityRepository(apiService: PDXApiService): PDXAbilityRepository {
        return PDXAbilityRepositoryImpl(apiService)
    }

    @Provides
    fun provideGetPokemonAbilityUseCase(repository: PDXAbilityRepository): PDXGetPokemonAbilitiesUseCase {
        return PDXGetPokemonAbilitiesUseCase(repository)
    }
}