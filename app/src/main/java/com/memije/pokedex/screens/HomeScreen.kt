package com.memije.pokedex.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.memije.core.theme.TypographyApp
import com.memije.pokemonlist.R
import com.memije.pokemonlist.presentation.ui.PokemonListWidget
import com.memije.pokemonlist.presentation.viewmodel.PokemonListViewModel

@Composable
fun HomeScreen(pokemonViewModel: PokemonListViewModel, navController: NavHostController) {
    Column {
        Text(
            text = stringResource(R.string.app_name),
            modifier = Modifier.padding(start = 16.dp, top = 16.dp),
            style = TypographyApp.displayMedium.copy(fontWeight = FontWeight.Bold)
        )
        PokemonListWidget(pokemonViewModel, navController)
    }
}