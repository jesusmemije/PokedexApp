package com.memije.pokedex.features.pokemons.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.memije.pokedex.core.utils.Response
import com.memije.pokedex.features.pokemons.domain.model.Pokemon
import com.memije.pokedex.features.pokemons.domain.usecase.GetPokemonListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PokemonListViewModel @Inject constructor(
    private val getPokemonListUseCase: GetPokemonListUseCase
) : ViewModel() {

    private val _pokemonList = MutableStateFlow<Response<List<Pokemon>>>(Response.Loading)
    val pokemonList: StateFlow<Response<List<Pokemon>>> = _pokemonList

    init {
        getPokemonList()
    }

    fun getPokemonList() {
        viewModelScope.launch {
            _pokemonList.value = getPokemonListUseCase()
        }
    }
}
