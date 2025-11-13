package com.memije.pokedex.features.detail.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.memije.pdxcore.network.model.PDXResponseGeneric
import com.memije.pokedex.features.detail.domain.model.PDXDetail
import com.memije.pokedex.features.detail.domain.usecase.PDXGetPokemonDetailUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PDXDetailViewModel @Inject constructor(
    private val getPokemonDetailUseCase: PDXGetPokemonDetailUseCase
) : ViewModel() {

    private val _pokemonDetail = MutableStateFlow<PDXResponseGeneric<PDXDetail>>(PDXResponseGeneric.Loading)
    val pokemonDetail: StateFlow<PDXResponseGeneric<PDXDetail>> = _pokemonDetail

    fun getPokemonDetail(name: String) {
        viewModelScope.launch {
            _pokemonDetail.value = getPokemonDetailUseCase(name)
        }
    }
}