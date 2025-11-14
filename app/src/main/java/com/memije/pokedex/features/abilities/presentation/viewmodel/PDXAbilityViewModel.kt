package com.memije.pokedex.features.abilities.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.memije.pdxcore.network.model.PDXResponseGeneric
import com.memije.pokedex.features.abilities.domain.model.PDXAbility
import com.memije.pokedex.features.abilities.domain.usecase.PDXGetPokemonAbilitiesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PDXAbilityViewModel @Inject constructor(
    private val getAbilitiesUseCase: PDXGetPokemonAbilitiesUseCase
) : ViewModel() {

    private val _pokemonAbility = MutableStateFlow<PDXResponseGeneric<PDXAbility>>(PDXResponseGeneric.Loading)
    val pokemonAbility: StateFlow<PDXResponseGeneric<PDXAbility>> = _pokemonAbility

    fun getPokemonAbility(name: String) {
        viewModelScope.launch {
            _pokemonAbility.value = getAbilitiesUseCase(name)
        }
    }
}
