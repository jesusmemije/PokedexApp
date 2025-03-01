package com.memije.pokemonlist.di

import com.memije.core.network.ApiService
import com.memije.pokemonlist.data.repository.PokemonListRepositoryImpl
import com.memije.pokemonlist.domain.repository.PokemonListRepository
import com.memije.pokemonlist.domain.usecase.GetPokemonListUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object PokemonListModule {

    @Provides
    fun providePokemonListRepository(apiService: ApiService): PokemonListRepository {
        return PokemonListRepositoryImpl(apiService)
    }

    @Provides
    fun provideGetPokemonListUseCase(repository: PokemonListRepository): GetPokemonListUseCase {
        return GetPokemonListUseCase(repository)
    }
}
