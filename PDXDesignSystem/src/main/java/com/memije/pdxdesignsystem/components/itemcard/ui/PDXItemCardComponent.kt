package com.memije.pdxdesignsystem.components.itemcard.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.memije.pdxdesignsystem.components.itemcard.model.PDXItemPokemonModel
import com.memije.pdxdesignsystem.theme.GreenLight
import com.memije.pdxdesignsystem.theme.LargeCornerRadius
import com.memije.pdxdesignsystem.theme.MediumSpacing
import com.memije.pdxdesignsystem.theme.TypographyApp

@Composable
fun PDXItemCardComponent(
    containerColor: Color, backgroundImage: Int, pokemon: PDXItemPokemonModel, clickItem: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(120.dp)
            .clickable { clickItem.invoke() },
        elevation = CardDefaults.cardElevation(0.dp),
        shape = RoundedCornerShape(LargeCornerRadius)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(GreenLight)
        ) {
            Box(
                modifier = Modifier
                    .weight(0.6f)
                    .padding(MediumSpacing)
            ) {
                Column {
                    Text(
                        text = pokemon.numberFormat,
                        style = TypographyApp.bodyLarge.copy(fontWeight = FontWeight.Medium)
                    )
                    Text(
                        text = pokemon.name,
                        style = TypographyApp.titleLarge.copy(fontWeight = FontWeight.Bold)
                    )
                }
            }

            Box(modifier = Modifier.weight(0.4f)) {
                Card(
                    shape = RoundedCornerShape(LargeCornerRadius), colors = CardDefaults.cardColors(
                        containerColor = containerColor
                    )
                ) {
                    Box(
                        modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center
                    ) {
                        Image(
                            painter = painterResource(backgroundImage),
                            contentDescription = null,
                            modifier = Modifier.size(100.dp)
                        )
                        Image(
                            painter = rememberAsyncImagePainter(pokemon.imageUrl),
                            contentDescription = null,
                            contentScale = ContentScale.Crop,
                            modifier = Modifier.size(100.dp)
                        )
                    }
                }
            }
        }
    }
}