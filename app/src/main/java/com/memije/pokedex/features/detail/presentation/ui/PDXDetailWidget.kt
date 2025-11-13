package com.memije.pokedex.features.detail.presentation.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import coil.compose.rememberAsyncImagePainter
import com.memije.pdxcore.network.model.PDXResponseGeneric
import com.memije.pdxcore.utils.routes.PDXAppRoutes
import com.memije.pdxdesignsystem.screens.PDXErrorScreen
import com.memije.pdxdesignsystem.screens.PDXLoadingScreen
import com.memije.pokedex.features.detail.domain.model.PDXDetail
import com.memije.pokedex.features.detail.presentation.viewmodel.PDXDetailViewModel
import java.util.Locale

@Composable
fun PDXDetailWidget(viewModel: PDXDetailViewModel, pokemonName: String, navController: NavHostController) {

    val pokemonDetail by viewModel.pokemonDetail.collectAsState()

    LaunchedEffect(pokemonName) {
        viewModel.getPokemonDetail(pokemonName)
    }

    when (pokemonDetail) {
        is PDXResponseGeneric.Loading -> PDXLoadingScreen()
        is PDXResponseGeneric.Success -> DetailContent((pokemonDetail as PDXResponseGeneric.Success<PDXDetail>).data, navController)
        is PDXResponseGeneric.Error -> PDXErrorScreen(message = (pokemonDetail as PDXResponseGeneric.Error).message) {
            viewModel.getPokemonDetail(pokemonName)
        }
    }
}

@Composable
fun DetailContent(pokemon: PDXDetail, navController: NavHostController) {
    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Image(
            painter = rememberAsyncImagePainter(pokemon.imageUrl),
            contentDescription = pokemon.name,
            contentScale = ContentScale.Crop,
            modifier = Modifier.size(150.dp).align(androidx.compose.ui.Alignment.CenterHorizontally)
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = "ID: ${pokemon.id}", style = MaterialTheme.typography.bodyLarge)
        Text(text = "Nombre: ${pokemon.name.replaceFirstChar {
            if (it.isLowerCase()) it.titlecase(
                Locale.ROOT
            ) else it.toString()
        }}", style = MaterialTheme.typography.headlineSmall)
        Text(text = "Altura: ${pokemon.height}", style = MaterialTheme.typography.bodyMedium)
        Text(text = "Peso: ${pokemon.weight}", style = MaterialTheme.typography.bodyMedium)
        Text(text = "Tipos: ${pokemon.types.joinToString(", ")}", style = MaterialTheme.typography.bodyMedium)
        // Lista de habilidades del Pokémon
        pokemon.abilities.forEach { ability ->
            Text(
                text = ability,
                modifier = Modifier
                    .clickable { navController.navigate(PDXAppRoutes.Ability.createRoute(ability)) }
                    .padding(8.dp)
            )
        }
    }
}