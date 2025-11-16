package com.memije.pdxdesignsystem.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import com.memije.pdxdesignsystem.theme.ExtraSmallSpacing
import com.memije.pdxdesignsystem.theme.LargeCornerRadius
import com.memije.pdxdesignsystem.theme.MediumLargeSpacing
import com.memije.pdxdesignsystem.theme.SmallSpacing
import com.memije.pdxdesignsystem.theme.TypographyApp

@Composable
fun PDXInfoCardComponent(
    icon: Painter,
    label: String,
    backgroundColor: Color,
) {
    Box(
        modifier = Modifier
            .background(backgroundColor, shape = RoundedCornerShape(LargeCornerRadius))
            .padding(vertical = ExtraSmallSpacing, horizontal = SmallSpacing)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(ExtraSmallSpacing)
        ) {
            Image(
                painter = icon,
                contentDescription = "Pokemon type $label",
                modifier = Modifier.size(MediumLargeSpacing)
            )
            Text(
                text = label,
                style = TypographyApp.bodyMedium.copy(fontWeight = FontWeight.Medium),
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        }
    }
}