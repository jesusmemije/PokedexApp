package com.memije.pokedex.features.detail.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.memije.pdxcore.network.model.PDXResponseGeneric
import com.memije.pokedex.features.detail.domain.model.PDXSpeciesDomainModel
import com.memije.pokedex.features.detail.domain.usecase.PDXGetPokemonDetailUseCase
import com.memije.pokedex.features.detail.domain.usecase.PDXGetPokemonSpeciesUseCase
import com.memije.pokedex.features.detail.presentation.mapper.toUI
import com.memije.pokedex.features.detail.presentation.model.PDXDetailUIModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PDXDetailViewModel @Inject constructor(
    private val getPokemonDetailUseCase: PDXGetPokemonDetailUseCase,
    private val getPokemonSpeciesUseCase: PDXGetPokemonSpeciesUseCase
) : ViewModel() {

    private val _pokemonDetail = MutableStateFlow<PDXResponseGeneric<PDXDetailUIModel>>(PDXResponseGeneric.Loading)
    val pokemonDetail: StateFlow<PDXResponseGeneric<PDXDetailUIModel>> = _pokemonDetail

    private val _pokemonSpecies = MutableStateFlow<PDXResponseGeneric<PDXSpeciesDomainModel>>(PDXResponseGeneric.Loading)
    val pokemonSpecies: StateFlow<PDXResponseGeneric<PDXSpeciesDomainModel>> = _pokemonSpecies

    val combinedPokemon: StateFlow<PDXResponseGeneric<Pair<PDXDetailUIModel, PDXSpeciesDomainModel>>> =
        combine(pokemonDetail, pokemonSpecies) { detailState, speciesState ->
            when {
                detailState is PDXResponseGeneric.Loading || speciesState is PDXResponseGeneric.Loading -> PDXResponseGeneric.Loading
                detailState is PDXResponseGeneric.Error -> PDXResponseGeneric.Error(detailState.message)
                speciesState is PDXResponseGeneric.Error -> PDXResponseGeneric.Error(speciesState.message)
                detailState is PDXResponseGeneric.Success && speciesState is PDXResponseGeneric.Success ->
                    PDXResponseGeneric.Success(detailState.data to speciesState.data)
                else -> PDXResponseGeneric.Loading
            }
        }.stateIn(viewModelScope, SharingStarted.Lazily, PDXResponseGeneric.Loading)


    fun getPokemonDetail(name: String) {
        viewModelScope.launch {
            _pokemonDetail.value = when (val result = getPokemonDetailUseCase(name)) {
                is PDXResponseGeneric.Success -> {
                    PDXResponseGeneric.Success(result.data.toUI())
                }

                is PDXResponseGeneric.Error -> PDXResponseGeneric.Error(result.message)
                is PDXResponseGeneric.Loading -> PDXResponseGeneric.Loading
            }
        }
    }

    fun getPokemonSpecies(name: String) {
        viewModelScope.launch {
            _pokemonSpecies.value = getPokemonSpeciesUseCase(name)
        }
    }
}