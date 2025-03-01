package com.memije.pokedex.features.abilities.presentation.ui

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.memije.pokedex.core.components.ErrorState
import com.memije.pokedex.core.components.LoadingState
import com.memije.pokedex.core.utils.Response
import com.memije.pokedex.features.abilities.domain.model.Ability
import com.memije.pokedex.features.abilities.presentation.viewmodel.PokemonAbilityViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PokemonAbilities(
    viewModel: PokemonAbilityViewModel,
    abilityName: String,
    navController: NavHostController
) {
    val pokemonAbility by viewModel.pokemonAbility.collectAsState()

    LaunchedEffect(abilityName) {
        viewModel.getPokemonAbility(abilityName)
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = abilityName, fontSize = 20.sp, fontWeight = FontWeight.Bold) },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(imageVector = Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Volver")
                    }
                }
            )
        }
    ) { padding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .background(MaterialTheme.colorScheme.background)
        ) {
            when (pokemonAbility) {
                is Response.Loading -> LoadingState()
                is Response.Success -> {
                    AnimatedVisibility(
                        visible = true,
                        enter = fadeIn(animationSpec = tween(700)) + expandVertically(),
                        exit = fadeOut(animationSpec = tween(500))
                    ) {
                        AbilityContent((pokemonAbility as? Response.Success<Ability>)?.data ?: Ability(0,"", ""))
                    }
                }
                is Response.Error -> ErrorState(
                    message = (pokemonAbility as Response.Error).message
                ) { viewModel.getPokemonAbility(abilityName) }
            }
        }
    }
}

@Composable
fun AbilityContent(ability: Ability) {
    Card(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth(),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
        elevation = CardDefaults.cardElevation(defaultElevation = 6.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = ability.name.uppercase(),
                style = MaterialTheme.typography.titleLarge,
                color = MaterialTheme.colorScheme.primary
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = ability.effect,
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.bodyLarge
            )
        }
    }
}
