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
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.memije.pdxcore.network.model.PDXResponseGeneric
import com.memije.pdxdesignsystem.screens.PDXErrorScreen
import com.memije.pdxdesignsystem.screens.PDXLoadingScreen
import com.memije.pdxdesignsystem.theme.LargeCornerRadius
import com.memije.pdxdesignsystem.theme.LargeSmallSpacing
import com.memije.pdxdesignsystem.theme.MediumSpacing
import com.memije.pdxdesignsystem.theme.SmallSpacing
import com.memije.pokedex.features.abilities.domain.model.PDXAbility
import com.memije.pokedex.features.abilities.presentation.viewmodel.PDXAbilityViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PDXAbilitiesWidget(
    viewModel: PDXAbilityViewModel,
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
                is PDXResponseGeneric.Loading -> PDXLoadingScreen()
                is PDXResponseGeneric.Success -> {
                    AnimatedVisibility(
                        visible = true,
                        enter = fadeIn(animationSpec = tween(700)) + expandVertically(),
                        exit = fadeOut(animationSpec = tween(500))
                    ) {
                        AbilityContent((pokemonAbility as? PDXResponseGeneric.Success<PDXAbility>)?.data ?: PDXAbility(
                            0,
                            "",
                            ""
                        )
                        )
                    }
                }
                is PDXResponseGeneric.Error -> PDXErrorScreen(
                    message = (pokemonAbility as PDXResponseGeneric.Error).message
                ) { viewModel.getPokemonAbility(abilityName) }
            }
        }
    }
}

@Composable
fun AbilityContent(ability: PDXAbility) {
    Card(
        modifier = Modifier
            .padding(MediumSpacing)
            .fillMaxWidth(),
        shape = RoundedCornerShape(LargeCornerRadius),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
        elevation = CardDefaults.cardElevation(defaultElevation = LargeSmallSpacing)
    ) {
        Column(
            modifier = Modifier.padding(MediumSpacing),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = ability.name.uppercase(),
                style = MaterialTheme.typography.titleLarge,
                color = MaterialTheme.colorScheme.primary
            )
            Spacer(modifier = Modifier.height(SmallSpacing))
            Text(
                text = ability.effect,
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.bodyLarge
            )
        }
    }
}
