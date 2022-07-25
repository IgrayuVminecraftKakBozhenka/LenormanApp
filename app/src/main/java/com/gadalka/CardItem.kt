package com.gadalka

import androidx.compose.animation.Crossfade
import androidx.compose.animation.animateColor
import androidx.compose.animation.core.*
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.gadalka.ui.theme.blue
import com.gadalka.ui.theme.lightBlue
import com.gadalka.ui.theme.white

@Composable
fun CardItem(
    id: Int,
    onClick: (Int) -> Unit
) {

    val screenWidth = LocalConfiguration.current.screenWidthDp
    val cardWidth = (screenWidth.dp - 64.dp) / 3
    val cardHeight = (cardWidth.value * 1.5).dp

    val infiniteTransition = rememberInfiniteTransition()

    val color by infiniteTransition.animateColor(
        initialValue = lightBlue,
        targetValue = blue,
        animationSpec = infiniteRepeatable(
            animation = tween(600, easing = LinearEasing),
            repeatMode = RepeatMode.Reverse
        )
    )

    val color2 by infiniteTransition.animateColor(
        initialValue = blue,
        targetValue = lightBlue,
        animationSpec = infiniteRepeatable(
            animation = tween(600, easing = LinearEasing),
            repeatMode = RepeatMode.Reverse
        )
    )

    Card(
        modifier = Modifier
            .height(cardHeight)
            .width(cardWidth),
        shape = RoundedCornerShape(10.dp),
        elevation = 3.dp,
        border = BorderStroke(1.dp, Brush.horizontalGradient(colors = listOf(color, color2)))
    ) {
        Crossfade(targetState = id != -1, animationSpec = tween(1000)) {
            if (it) {
                Image(
                    painter = getImage(id = id),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .clickable { onClick(id) }
                        .fillMaxSize()
                )
            } else {
                Image(
                    painter = painterResource(id = R.drawable.card_place_holder),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxSize()
                )
            }
        }


    }
}
