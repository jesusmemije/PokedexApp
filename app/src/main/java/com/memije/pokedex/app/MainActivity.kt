package com.memije.pokedex.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.navigation.compose.rememberNavController
import com.memije.pokedex.app.navigation.NavigationGraph
import com.memije.pokemonskills.presentation.viewmodel.PokemonAbilityViewModel
import com.memije.pokemondetail.presentation.viewmodel.PokemonDetailViewModel
import com.memije.core.theme.PokedexAppTheme
import com.memije.pokemonlist.presentation.viewmodel.PokemonListViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val pokemonListViewModel: PokemonListViewModel by viewModels()
    private val pokemonDetailViewModel: PokemonDetailViewModel by viewModels()
    private val abilityViewModel: PokemonAbilityViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PokedexAppTheme {
                val navController = rememberNavController()
                NavigationGraph(
                    navController = navController,
                    pokemonViewModel = pokemonListViewModel,
                    abilityViewModel = abilityViewModel,
                    pokemonDetailViewModel = pokemonDetailViewModel
                )
            }
        }
    }
}
