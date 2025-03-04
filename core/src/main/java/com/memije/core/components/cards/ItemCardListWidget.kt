package com.memije.core.components.cards

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
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.memije.core.model.PokemonCoreModel
import com.memije.core.theme.GreenLight
import com.memije.core.theme.GreenMedium
import com.memije.core.theme.TypographyApp
import com.memije.core.utils.extensions.capitalizeFirstLetter
import com.memije.core.utils.extensions.toFormatNumber

@Composable
fun ItemCardListWidget(
    containerColor: Color, backgroundImage: Int, pokemon: PokemonCoreModel, clickItem: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(120.dp)
            .clickable { clickItem.invoke() },
        elevation = CardDefaults.cardElevation(0.dp),
        shape = RoundedCornerShape(16.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(GreenLight)
        ) {
            Box(
                modifier = Modifier
                    .weight(0.6f)
                    .padding(16.dp)
            ) {
                Column {
                    Text(
                        text = pokemon.id.toFormatNumber(),
                        style = TypographyApp.bodyLarge.copy(fontWeight = FontWeight.Medium)
                    )
                    Text(
                        text = pokemon.name.capitalizeFirstLetter(),
                        style = TypographyApp.titleLarge.copy(fontWeight = FontWeight.Bold)
                    )
                }
            }

            Box(modifier = Modifier.weight(0.4f)) {
                Card(
                    shape = RoundedCornerShape(16.dp), colors = CardDefaults.cardColors(
                        containerColor = containerColor
                    )
                ) {
                    Box(
                        modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center
                    ) {
                        Image(painter = painterResource(backgroundImage),
                            contentDescription = "Background Image",
                            modifier = Modifier
                                .size(100.dp)
                                .drawWithContent {
                                    drawContent()
                                    drawRect(
                                        brush = Brush.verticalGradient(
                                            colors = listOf(
                                                Color.Transparent, GreenMedium.copy(alpha = 0.7f)
                                            ), startY = 0f, endY = size.height * 0.8f
                                        )
                                    )
                                })
                        Image(
                            painter = rememberAsyncImagePainter(pokemon.imageUrl),
                            contentDescription = "Pokemon",
                            contentScale = ContentScale.Crop,
                            modifier = Modifier.size(100.dp)
                        )
                    }
                }
            }
        }
    }
}