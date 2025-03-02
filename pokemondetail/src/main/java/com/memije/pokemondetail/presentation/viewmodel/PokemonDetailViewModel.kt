package com.memije.pokemondetail.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.memije.pokemondetail.domain.model.PokemonDetail
import com.memije.pokemondetail.domain.usecase.GetPokemonDetailUseCase
import com.memije.core.network.model.Response
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PokemonDetailViewModel @Inject constructor(
    private val getPokemonDetailUseCase: GetPokemonDetailUseCase
) : ViewModel() {

    private val _pokemonDetail = MutableStateFlow<Response<PokemonDetail>>(Response.Loading)
    val pokemonDetail: StateFlow<Response<PokemonDetail>> = _pokemonDetail

    fun getPokemonDetail(name: String) {
        viewModelScope.launch {
            _pokemonDetail.value = getPokemonDetailUseCase(name)
        }
    }
}