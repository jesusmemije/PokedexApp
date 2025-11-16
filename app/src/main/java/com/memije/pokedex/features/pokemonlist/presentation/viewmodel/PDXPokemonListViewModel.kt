package com.memije.pokedex.features.pokemonlist.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.memije.pdxcore.network.model.PDXResponseGeneric
import com.memije.pokedex.features.pokemonlist.domain.usecase.PDXGetPokemonListUseCase
import com.memije.pokedex.features.pokemonlist.presentation.mapper.toUI
import com.memije.pokedex.features.pokemonlist.presentation.model.PDXPokemonUIModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PDXPokemonListViewModel @Inject constructor(
    private val getPokemonListUseCase: PDXGetPokemonListUseCase
) : ViewModel() {

    private val _pokemonList = MutableStateFlow<PDXResponseGeneric<List<PDXPokemonUIModel>>>(PDXResponseGeneric.Loading)
    val pokemonList: StateFlow<PDXResponseGeneric<List<PDXPokemonUIModel>>> = _pokemonList

    init {
        getPokemonList()
    }

    fun getPokemonList() {
        viewModelScope.launch {
            _pokemonList.value = when (val result = getPokemonListUseCase()) {
                is PDXResponseGeneric.Success -> {
                    PDXResponseGeneric.Success(result.data.toUI())
                }

                is PDXResponseGeneric.Error -> PDXResponseGeneric.Error(result.message)
                is PDXResponseGeneric.Loading -> PDXResponseGeneric.Loading
            }
        }
    }
}
