package com.memije.pokemonlist.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.memije.pokemonlist.domain.usecase.GetPokemonListUseCase
import com.memije.pokedexgeneric.utils.Response
import com.memije.pokemonlist.domain.model.Pokemon
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
