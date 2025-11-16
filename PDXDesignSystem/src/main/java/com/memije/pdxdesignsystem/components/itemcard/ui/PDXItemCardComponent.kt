package com.memije.pdxdesignsystem.components.itemcard.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import coil.compose.rememberAsyncImagePainter
import com.memije.pdxcore.utils.constants.PDXAppConstants.IMAGE_CONTENT_WEIGHT
import com.memije.pdxcore.utils.constants.PDXAppConstants.TEXT_CONTENT_WEIGHT
import com.memije.pdxdesignsystem.components.PDXInfoCardComponent
import com.memije.pdxdesignsystem.components.itemcard.model.PDXItemPokemonUIModel
import com.memije.pdxdesignsystem.theme.ItemCardHeight
import com.memije.pdxdesignsystem.theme.ItemCardImageSize
import com.memije.pdxdesignsystem.theme.LargeCornerRadius
import com.memije.pdxdesignsystem.theme.MediumSpacing
import com.memije.pdxdesignsystem.theme.SmallSpacing
import com.memije.pdxdesignsystem.theme.TypographyApp
import com.memije.pdxdesignsystem.theme.ZeroElevation

@Composable
fun PDXItemCardComponent(
    pokemon: PDXItemPokemonUIModel,
    clickItem: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(ItemCardHeight)
            .clickable(onClick = clickItem),
        elevation = CardDefaults.cardElevation(ZeroElevation),
        shape = RoundedCornerShape(LargeCornerRadius)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(pokemon.backgroundCard)
        ) {
            Column(
                modifier = Modifier
                    .weight(TEXT_CONTENT_WEIGHT)
                    .padding(MediumSpacing)
            ) {
                Text(
                    text = pokemon.numberFormat,
                    style = TypographyApp.bodyLarge.copy(fontWeight = FontWeight.Medium)
                )
                Text(
                    text = pokemon.name,
                    style = TypographyApp.titleLarge.copy(fontWeight = FontWeight.Bold)
                )
                Spacer(modifier = Modifier.height(SmallSpacing))
                Row {
                    pokemon.types.forEach { type ->
                        PDXInfoCardComponent(
                            icon = painterResource(id = type.iconRes),
                            label = type.name,
                            backgroundColor = type.color
                        )
                        Spacer(Modifier.width(SmallSpacing))
                    }
                }
            }

            Box(modifier = Modifier.weight(IMAGE_CONTENT_WEIGHT)) {
                Card(
                    shape = RoundedCornerShape(LargeCornerRadius),
                    colors = CardDefaults.cardColors(
                        containerColor = pokemon.backgroundPokemon
                    )
                ) {
                    Box(
                        modifier = Modifier.fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ) {
                        Image(
                            painter = painterResource(pokemon.imagenPokemon),
                            contentDescription = null, // Decorative image
                            modifier = Modifier.size(ItemCardImageSize)
                        )
                        Image(
                            painter = rememberAsyncImagePainter(pokemon.imageUrl),
                            contentDescription = "Image of ${pokemon.name}",
                            contentScale = ContentScale.Crop,
                            modifier = Modifier.size(ItemCardImageSize)
                        )
                    }
                }
            }
        }
    }
}