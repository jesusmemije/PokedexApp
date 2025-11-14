package com.memije.pokedex.di

import com.memije.pdxcore.network.PDXApiService
import com.memije.pokedex.features.detail.data.repository.PDXDetailRepositoryImpl
import com.memije.pokedex.features.detail.domain.repository.PDXDetailRepository
import com.memije.pokedex.features.detail.domain.usecase.PDXGetPokemonDetailUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object PDXDetailModule {

    @Provides
    fun providePokemonDetailRepository(apiService: PDXApiService): PDXDetailRepository {
        return PDXDetailRepositoryImpl(apiService)
    }

    @Provides
    fun provideGetPokemonDetailUseCase(repository: PDXDetailRepository): PDXGetPokemonDetailUseCase {
        return PDXGetPokemonDetailUseCase(repository)
    }
}