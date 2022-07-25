package com.gadalka

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.gadalka.ui.theme.RobotoRBold

@Composable
fun DescriptionBottomSheet(
    id: Int
) {

    val screenWidth = LocalConfiguration.current.screenWidthDp
    val cardWidth = (screenWidth / 2).dp
    val cardHeight = (cardWidth.value * 1.5).dp

    Column(modifier = Modifier.fillMaxWidth()) {
        Text(
            text = getTitle(id = id),
            fontSize = 18.sp,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            textAlign = TextAlign.Center,
            fontFamily = RobotoRBold,
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
        )

        Card(
            modifier = Modifier
                .padding(start = 16.dp, end = 16.dp)
                .width(cardWidth)
                .height(cardHeight)
                .align(Alignment.CenterHorizontally)
        ) {
            Image(
                painter = getImage(id = id),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()
            )
        }
    }
}