package com.memije.pokedex.features.abilities.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.memije.pokedex.core.utils.Response
import com.memije.pokedex.features.abilities.domain.model.Ability
import com.memije.pokedex.features.abilities.domain.usecase.GetPokemonAbilityUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PokemonAbilityViewModel @Inject constructor(
    private val getAbilitiesUseCase: GetPokemonAbilityUseCase
) : ViewModel() {

    private val _pokemonAbility = MutableStateFlow<Response<Ability>>(Response.Loading)
    val pokemonAbility: StateFlow<Response<Ability>> = _pokemonAbility

    fun getPokemonAbility(name: String) {
        viewModelScope.launch {
            _pokemonAbility.value = getAbilitiesUseCase(name)
        }
    }
}
