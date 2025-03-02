package com.memije.pokemonlist.presentation.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import coil.compose.rememberAsyncImagePainter
import com.memije.core.components.ErrorState
import com.memije.core.components.LoadingState
import com.memije.core.network.model.Response
import com.memije.core.utils.Routes
import com.memije.pokemonlist.R
import com.memije.pokemonlist.domain.model.Pokemon
import com.memije.pokemonlist.presentation.viewmodel.PokemonListViewModel

@Composable
fun PokemonList(viewModel: PokemonListViewModel, navController: NavHostController) {

    val pokemonList by viewModel.pokemonList.collectAsState()

    when (pokemonList) {
        is Response.Loading -> LoadingState()
        is Response.Success -> PokemonList(
            (pokemonList as Response.Success<List<Pokemon>>).data,
            navController
        )
        is Response.Error -> ErrorState(message = (pokemonList as Response.Error).message) {
            viewModel.getPokemonList()
        }
    }
}

@Composable
fun PokemonList(pokemonList: List<Pokemon>, navController: NavController) {
    Column {
        Text(
            text = stringResource(R.string.app_name),
            modifier = Modifier.padding(start = 16.dp, top = 16.dp),
            fontSize = 28.sp
        )
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            modifier = Modifier.padding(8.dp),
            contentPadding = PaddingValues(8.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(pokemonList) { pokemon ->
                GridItemCard(pokemon, navController)
            }
        }
    }
}

@Composable
fun GridItemCard(pokemon: Pokemon, navController: NavController) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(150.dp),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Row(
            modifier = Modifier
                .padding(8.dp)
                .clickable { navController.navigate(Routes.Details.createRoute(pokemon.name)) }
        ) {
            Column {
                Text(text = pokemon.name)
                Text(text = pokemon.name)
                Text(text = pokemon.name)
            }
            Image(
                painter = rememberAsyncImagePainter(pokemon.imageUrl),
                contentDescription = pokemon.name,
                contentScale = ContentScale.Crop,
                modifier = Modifier.size(100.dp)
            )
        }
    }
}
