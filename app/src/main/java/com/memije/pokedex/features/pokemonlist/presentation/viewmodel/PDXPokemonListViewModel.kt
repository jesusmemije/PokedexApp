package com.memije.pokedex.features.pokemonlist.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.memije.pdxcore.network.model.PDXResponseGeneric
import com.memije.pokedex.features.pokemonlist.domain.model.PDXPokemon
import com.memije.pokedex.features.pokemonlist.domain.usecase.PDXGetPokemonListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PDXPokemonListViewModel @Inject constructor(
    private val getPokemonListUseCase: PDXGetPokemonListUseCase
) : ViewModel() {

    private val _pokemonList = MutableStateFlow<PDXResponseGeneric<List<PDXPokemon>>>(PDXResponseGeneric.Loading)
    val pokemonList: StateFlow<PDXResponseGeneric<List<PDXPokemon>>> = _pokemonList

    init {
        getPokemonList()
    }

    fun getPokemonList() {
        viewModelScope.launch {
            _pokemonList.value = getPokemonListUseCase()
        }
    }
}
