package com.memije.pokedex.app.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.navigation.compose.rememberNavController
import com.memije.pdxdesignsystem.theme.PokedexAppTheme
import com.memije.pdxdesignsystem.R
import com.memije.pokedex.app.navigation.PDXNavigationGraph
import com.memije.pokedex.features.abilities.presentation.viewmodel.PDXAbilityViewModel
import com.memije.pokedex.features.detail.presentation.viewmodel.PDXDetailViewModel
import com.memije.pokedex.features.pokemonlist.presentation.viewmodel.PDXPokemonListViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val pokemonListViewModel: PDXPokemonListViewModel by viewModels()
    private val pokemonDetailViewModel: PDXDetailViewModel by viewModels()
    private val abilityViewModel: PDXAbilityViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        // Change Theme Pokedex ==> Splash
        setTheme(R.style.Theme_Pokedex)
        super.onCreate(savedInstanceState)
        setContent {
            PokedexAppTheme {
                val navController = rememberNavController()
                PDXNavigationGraph(
                    navController = navController,
                    pokemonViewModel = pokemonListViewModel,
                    abilityViewModel = abilityViewModel,
                    pokemonDetailViewModel = pokemonDetailViewModel
                )
            }
        }
    }
}