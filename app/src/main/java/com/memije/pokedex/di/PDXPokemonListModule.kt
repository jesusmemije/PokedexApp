package com.memije.pokedex.di

import com.memije.pdxcore.network.PDXApiService
import com.memije.pokedex.features.pokemonlist.data.repository.PDXPokemonListRepositoryImpl
import com.memije.pokedex.features.pokemonlist.domain.repository.PDXPokemonListRepository
import com.memije.pokedex.features.pokemonlist.domain.usecase.PDXGetPokemonListUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object PDXPokemonListModule {

    @Provides
    fun providePokemonListRepository(apiService: PDXApiService): PDXPokemonListRepository {
        return PDXPokemonListRepositoryImpl(apiService)
    }

    @Provides
    fun provideGetPokemonListUseCase(repository: PDXPokemonListRepository): PDXGetPokemonListUseCase {
        return PDXGetPokemonListUseCase(repository)
    }
}