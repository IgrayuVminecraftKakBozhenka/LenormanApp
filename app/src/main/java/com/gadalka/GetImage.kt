package com.gadalka

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import com.gadalka.models.CardModel

@Composable
fun getImage(id: Int): Painter {
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
        12 -> painterResource(id = R.drawable.twelve_owls)
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

@Composable
fun getTitle(id: Int): String {
   return when (id) {
        1 -> stringResource(R.string.one_horseman)
        2 -> stringResource(R.string.two_clever)
        3 -> stringResource(R.string.three_ship)
        4 -> stringResource(R.string.four_house)
        5 -> stringResource(R.string.five_tree)
        6 -> stringResource(R.string.six_clouds)
        7 -> stringResource(R.string.seven_snake)
        8 -> stringResource(R.string.eight_coffin)
        9 -> stringResource(R.string.nine_flowers)
        10 -> stringResource(R.string.ten_sycthe)
        11 -> stringResource(R.string.eleven_broom)
        12 -> stringResource(R.string.twelve_owls)
        13 -> stringResource(R.string.threeteen_child)
        14 -> stringResource(R.string.fourteen_fox)
        15 -> stringResource(R.string.fiveteen_bear)
        16 -> stringResource(R.string.sixteen_stars)
        17 -> stringResource(R.string.seventeen_stork)
        18 -> stringResource(R.string.eighteen_dog)
        19 -> stringResource(R.string.nineteen_tower)
        20 -> stringResource(R.string.twenty_garden)
        21 -> stringResource(R.string.twentyone_mountain)
        22 -> stringResource(R.string.twentytwo_road)
        23 -> stringResource(R.string.twentythree_road)
        24 -> stringResource(R.string.twentyfour_rats)
        25 -> stringResource(R.string.twentyfive_ring)
        26 -> stringResource(R.string.twentysix_book)
        27 -> stringResource(R.string.twentyseven_letter)
        28 -> stringResource(R.string.twentyeight_man)
        29 -> stringResource(R.string.twentynine_woman)
        30 -> stringResource(R.string.thirty_lilies)
        31 -> stringResource(R.string.thirtyone_sun)
        32 -> stringResource(R.string.thirtytwo_mun)
        33 -> stringResource(R.string.thirtythree_key)
        34 -> stringResource(R.string.thirtyfour_fish)
        35 -> stringResource(R.string.thirtyfive_anchor)
        36 -> stringResource(R.string.thirtysix_cross)
       else -> stringResource(R.string.card_description)
    }

}