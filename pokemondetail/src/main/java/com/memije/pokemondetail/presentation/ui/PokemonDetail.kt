package com.memije.pokemondetail.presentation.ui

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
import com.memije.pokemondetail.domain.model.PokemonDetail
import com.memije.pokemondetail.presentation.viewmodel.PokemonDetailViewModel
import com.memije.core.components.ErrorState
import com.memije.core.components.LoadingState
import com.memije.core.network.model.Response
import com.memije.core.utils.Routes
import java.util.Locale

@Composable
fun PokemonDetail(viewModel: PokemonDetailViewModel, pokemonName: String, navController: NavHostController) {

    val pokemonDetail by viewModel.pokemonDetail.collectAsState()

    LaunchedEffect(pokemonName) {
        viewModel.getPokemonDetail(pokemonName)
    }

    when (pokemonDetail) {
        is Response.Loading -> LoadingState()
        is Response.Success -> DetailContent((pokemonDetail as Response.Success<PokemonDetail>).data, navController)
        is Response.Error -> ErrorState(message = (pokemonDetail as Response.Error).message) {
            viewModel.getPokemonDetail(pokemonName)
        }
    }
}

@Composable
fun DetailContent(pokemon: PokemonDetail, navController: NavHostController) {
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
                    .clickable { navController.navigate(Routes.Ability.createRoute(ability)) }
                    .padding(8.dp)
            )
        }
    }
}