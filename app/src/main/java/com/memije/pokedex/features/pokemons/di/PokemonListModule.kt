package com.memije.pokedex.features.pokemons.di

import com.memije.pokedex.core.network.ApiService
import com.memije.pokedex.features.pokemons.data.repository.PokemonListRepositoryImpl
import com.memije.pokedex.features.pokemons.domain.repository.PokemonListRepository
import com.memije.pokedex.features.pokemons.domain.usecase.GetPokemonListUseCase
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
