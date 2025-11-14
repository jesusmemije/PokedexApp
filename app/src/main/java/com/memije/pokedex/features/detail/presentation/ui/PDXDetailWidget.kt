package com.memije.pokedex.features.detail.presentation.ui

import androidx.activity.compose.LocalOnBackPressedDispatcherOwner
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import coil.compose.rememberAsyncImagePainter
import com.memije.pdxcore.network.model.PDXResponseGeneric
import com.memije.pdxcore.utils.routes.PDXAppRoutes
import com.memije.pdxdesignsystem.R
import com.memije.pdxdesignsystem.components.PDXInfoCardComponent
import com.memije.pdxdesignsystem.screens.PDXErrorScreen
import com.memije.pdxdesignsystem.screens.PDXLoadingScreen
import com.memije.pdxdesignsystem.theme.ExtraSmallSpacing
import com.memije.pdxdesignsystem.theme.MediumIconSize
import com.memije.pdxdesignsystem.theme.MediumLargeSpacing
import com.memije.pdxdesignsystem.theme.MediumSpacing
import com.memije.pdxdesignsystem.theme.SmallSpacing
import com.memije.pdxdesignsystem.theme.TypographyApp
import com.memije.pokedex.features.detail.domain.model.PDXSpeciesDomainModel
import com.memije.pokedex.features.detail.presentation.model.PDXDetailUIModel
import com.memije.pokedex.features.detail.presentation.util.getFlavorTextEs
import com.memije.pokedex.features.detail.presentation.viewmodel.PDXDetailViewModel

@Composable
fun PDXDetailWidget(viewModel: PDXDetailViewModel, pokemonName: String, navController: NavHostController) {

    val combinedState by viewModel.combinedPokemon.collectAsState()

    LaunchedEffect(pokemonName) {
        viewModel.getPokemonDetail(pokemonName)
        viewModel.getPokemonSpecies(pokemonName)
    }

    when (combinedState) {
        is PDXResponseGeneric.Loading -> PDXLoadingScreen()
        is PDXResponseGeneric.Success -> {
            val data = (combinedState as PDXResponseGeneric.Success<Pair<PDXDetailUIModel, PDXSpeciesDomainModel>>).data
            DetailContent(detail = data.first, species = data.second, navController = navController)
        }
        is PDXResponseGeneric.Error -> {
            val message = (combinedState as PDXResponseGeneric.Error).message
            PDXErrorScreen(message = message) {
                viewModel.getPokemonDetail(pokemonName)
                viewModel.getPokemonSpecies(pokemonName)
            }
        }
    }
}

@Composable
fun DetailContent(detail: PDXDetailUIModel, species: PDXSpeciesDomainModel, navController: NavHostController) {

    val backDispatcher = LocalOnBackPressedDispatcherOwner.current?.onBackPressedDispatcher

    Column(modifier = Modifier.fillMaxSize()) {
        Box(
            modifier = Modifier.fillMaxWidth(),
            contentAlignment = Alignment.TopCenter
        ) {
            // Background Green
            Image(
                painter = painterResource(id = detail.pokemonDetailUI.backgroundImageRes),
                contentDescription = null,
                modifier = Modifier.fillMaxWidth(),
                contentScale = ContentScale.FillWidth
            )

            // Background Sheet
            Image(
                painter = painterResource(id = detail.pokemonDetailUI.iconImageRes),
                contentDescription = null,
                modifier = Modifier.align(Alignment.Center)
            )

            // Top icons (Back y Favorite)
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = MediumSpacing, vertical = MediumLargeSpacing)
                    .align(Alignment.TopCenter),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {

                IconButton(onClick = { backDispatcher?.onBackPressed() }) {
                    Icon(
                        painter = painterResource(id = R.drawable.pdx_icon_arrow_back),
                        contentDescription = null,
                        modifier = Modifier.size(MediumIconSize),
                        tint = Color.White
                    )
                }

                IconButton(onClick = {  }) {
                    Icon(
                        painter = painterResource(id = R.drawable.pdx_icon_favorite),
                        contentDescription = "Favorito",
                        modifier = Modifier.size(MediumIconSize),
                        tint = Color.White
                    )
                }
            }

            // Imagen Pokemón
            Image(
                painter = rememberAsyncImagePainter(detail.imageUrl),
                contentDescription = detail.name,
                contentScale = ContentScale.Fit,
                modifier = Modifier
                    .size(280.dp)
                    .align(Alignment.BottomCenter)
                    .offset(y = 80.dp)
            )
        }

        Spacer(modifier = Modifier.height(MediumSpacing))

        Column(modifier = Modifier.padding(MediumSpacing)) {
            Text(
                text = detail.name,
                style = TypographyApp.headlineLarge
            )

            Text(
                text = detail.numberFormat,
                style = TypographyApp.bodyLarge,
                modifier = Modifier.padding(top = ExtraSmallSpacing)
            )

            Spacer(modifier = Modifier.padding(top = MediumSpacing))

            Row {
                detail.types.forEach { type ->
                    PDXInfoCardComponent(
                        icon = painterResource(id = type.iconRes),
                        label = type.name,
                        backgroundColor = type.color
                    )
                    Spacer(Modifier.width(SmallSpacing))
                }
            }

            Text(
                text = species.flavorTextEntries
                    .getFlavorTextEs()
                    ?.replace("\\s+".toRegex(), " ")
                    ?.trim()
                    .orEmpty(),
                style = TypographyApp.bodyLarge,
                textAlign = TextAlign.Justify,
                modifier = Modifier.padding(top = MediumSpacing)
            )

            Spacer(modifier = Modifier.padding(top = MediumSpacing))

            Text(text = "Altura: ${detail.height}", style = MaterialTheme.typography.bodyMedium)
            Text(text = "Peso: ${detail.weight}", style = MaterialTheme.typography.bodyMedium)

            // Lista de habilidades del Pokémon
            detail.abilities.forEach { ability ->
                Text(
                    text = ability,
                    modifier = Modifier
                        .clickable { navController.navigate(PDXAppRoutes.Ability.createRoute(ability)) }
                        .padding(SmallSpacing)
                )
            }
        }
    }
}