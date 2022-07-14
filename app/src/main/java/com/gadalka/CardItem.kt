package com.gadalka

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@Composable
fun CardItem(
    id: Int,
    onClick: (Int) -> Unit
) {
    Card(
        modifier = Modifier
            .height(150.dp)
            .width(100.dp)
            .clickable { onClick(id) },
        shape = RoundedCornerShape(10.dp),
        elevation = 3.dp
        // border = BorderStroke(3.dp, Brush.horizontalGradient())
    ) {
        Image(
            painter = getImage(id = id),
            contentDescription = null,
            contentScale = ContentScale.Crop
        )

    }
}

@Composable
private fun getImage(id: Int): Painter {
    return when (id) {
        1 -> painterResource(id = R.drawable.one_horseman)
        2 -> painterResource(id = R.drawable.two_clever)
        3 -> painterResource(id = R.drawable.three_ship)
        4 -> painterResource(id = R.drawable.four_mansion)
        5 -> painterResource(id = R.drawable.five_tree)
        6 -> painterResource(id = R.drawable.six_cloud)
        7 -> painterResource(id = R.drawable.seven_snake)
        8 -> painterResource(id = R.drawable.eight_coffin)
        9 -> painterResource(id = R.drawable.nine_flowers)
        10 -> painterResource(id = R.drawable.ten_scythe)
        11 -> painterResource(id = R.drawable.eleven_broom)
        12 -> painterResource(id = R.drawable.twenteen_owls)
        13 -> painterResource(id = R.drawable.threeteen_girl)
        14 -> painterResource(id = R.drawable.fourteen_fox)
        15 -> painterResource(id = R.drawable.fiveteen_bear)
        16 -> painterResource(id = R.drawable.sixteen_stars)
        17 -> painterResource(id = R.drawable.seventeen_stork)
        18 -> painterResource(id = R.drawable.eighteen_dog)
        19 -> painterResource(id = R.drawable.nineteen_tower)
        20 -> painterResource(id = R.drawable.twenty_garden)
        21 -> painterResource(id = R.drawable.twentyone_mountain)
        22 -> painterResource(id = R.drawable.twentytwo_road)
        23 -> painterResource(id = R.drawable.twentythree_rat)
        24 -> painterResource(id = R.drawable.twentyfour_heart)
        25 -> painterResource(id = R.drawable.twentyfive_ring)
        26 -> painterResource(id = R.drawable.twentysix_book)
        27 -> painterResource(id = R.drawable.twentyseven_letter)
        28 -> painterResource(id = R.drawable.twentyeight_man)
        29 -> painterResource(id = R.drawable.twentynine_woman)
        30 -> painterResource(id = R.drawable.thirty_lilies)
        31 -> painterResource(id = R.drawable.thirtyone_sun)
        32 -> painterResource(id = R.drawable.thirtytwo_mun)
        33 -> painterResource(id = R.drawable.thirtythree_key)
        34 -> painterResource(id = R.drawable.thirtyfour_fish)
        35 -> painterResource(id = R.drawable.thirtyfive_anchor)
        36 -> painterResource(id = R.drawable.thirtysix_cross)
        else -> painterResource(id = R.drawable.card_place_holder)
    }
}