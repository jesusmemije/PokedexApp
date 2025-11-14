package com.memije.pokedex.di

import com.memije.pdxcore.network.PDXApiService
import com.memije.pokedex.features.detail.data.repository.PDXSpeciesRepositoryImpl
import com.memije.pokedex.features.detail.domain.repository.PDXSpeciesRepository
import com.memije.pokedex.features.detail.domain.usecase.PDXGetPokemonSpeciesUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object PDXSpeciesModule {

    @Provides
    fun providePokemonSpeciesRepository(apiService: PDXApiService): PDXSpeciesRepository {
        return PDXSpeciesRepositoryImpl(apiService)
    }

    @Provides
    fun provideGetPokemonSpeciesUseCase(repository: PDXSpeciesRepository): PDXGetPokemonSpeciesUseCase {
        return PDXGetPokemonSpeciesUseCase(repository)
    }
}