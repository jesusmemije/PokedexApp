package com.memije.pokedex.features.pokemonlist.presentation.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.navigation.NavHostController
import com.memije.pdxdesignsystem.R
import com.memije.pdxdesignsystem.theme.MediumSpacing
import com.memije.pdxdesignsystem.theme.TypographyApp
import com.memije.pokedex.features.pokemonlist.presentation.viewmodel.PDXPokemonListViewModel

@Composable
fun PDXHomeScreen(pokemonViewModel: PDXPokemonListViewModel, navController: NavHostController) {
    Column {
        Text(
            text = stringResource(R.string.app_name),
            modifier = Modifier.padding(start = MediumSpacing, top = MediumSpacing),
            style = TypographyApp.displayMedium.copy(fontWeight = FontWeight.Bold)
        )
        PDXPokemonListWidget(pokemonViewModel, navController)
    }
}