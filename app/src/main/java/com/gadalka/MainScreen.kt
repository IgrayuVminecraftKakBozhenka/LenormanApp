package com.gadalka

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.gadalka.mvi.Intent
import com.gadalka.mvi.State
import com.gadalka.ui.theme.*
import com.google.accompanist.insets.ProvideWindowInsets
import com.google.accompanist.insets.navigationBarsWithImePadding
import com.google.accompanist.insets.statusBarsPadding
import kotlinx.coroutines.launch

@SuppressLint("CoroutineCreationDuringComposition")
@OptIn(ExperimentalMaterialApi::class)
@Composable
fun MainScreen(state: State, performIntent: (Intent) -> Unit) {

    val cardWidth = 200.dp
    val cardOffset = animateDpAsState(cardWidth * state.offset)
    val bottomSheetState =
        rememberModalBottomSheetState(ModalBottomSheetValue.Hidden) { value ->
            if (value == ModalBottomSheetValue.Hidden) {
                performIntent(Intent.ClearDescriptions)
            }
            true
        }

    val lazyState = rememberLazyListState()
    val scope = rememberCoroutineScope()


        with(lazyState) {
            Log.d("SCROLLING", firstVisibleItemIndex.toString())
            if (firstVisibleItemIndex == 34) {
                scope.launch {
                    Log.d("SCROLLING", "LAUNCHED")
                    animateScrollToItem(0)
                    Log.d("SCROLLING", "SCROLLED")
                }
            }
        }


    LaunchedEffect(key1 = state.bottomSheetShown, block = {
        if (state.bottomSheetShown) {
            bottomSheetState.show()
        } else {
            bottomSheetState.hide()
        }
    })

    ProvideWindowInsets(windowInsetsAnimationsEnabled = true) {

        ModalBottomSheetLayout(
            modifier = Modifier
                .statusBarsPadding()
                .navigationBarsWithImePadding()
                .background(base),
            sheetContent = { DescriptionBottomSheet(state.actualCardId) },
            sheetState = bottomSheetState,
            sheetShape = RoundedCornerShape(10.dp)
        ) {
            Column {
                Card(
                    shape = RoundedCornerShape(0.dp),
                    elevation = 10.dp,
                    backgroundColor = surface
                ){
                    Row(
                        modifier = Modifier
                            .padding(16.dp)
                            .fillMaxWidth()
                            .height(232.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {

                        CardItem(
                            id = state.firstCard.id,
                            onClick = { performIntent(Intent.CardDescriptionClick(it)) }
                        )

                        CardItem(
                            id = state.secondCard.id,
                            onClick = { performIntent(Intent.CardDescriptionClick(it)) }
                        )

                        CardItem(
                            id = state.thirdCard.id,
                            onClick = { performIntent(Intent.CardDescriptionClick(it)) }
                        )
                    }
                }

               // Divider(modifier = Modifier.fillMaxWidth())

                LazyRow(
                    modifier = Modifier.padding(top = 16.dp, bottom = 16.dp),
                    state = lazyState
                ) {
                    itemsIndexed(state.allCards) { index, item ->
                        DisabledCardItem(
                            id = item.id,
                            cardOffset =
                            if (index % 2 == 0) 0.dp else -(cardOffset.value),
                            onClick = { performIntent(Intent.OnCardClick(it)) }
                        )
                    }
                }

                Button(
                    onClick = { performIntent(Intent.ShuffleCards) },
                    shape = RoundedCornerShape(10.dp),
                    modifier = Modifier
                        .padding(16.dp)
                        .height(56.dp)
                        .fillMaxWidth()
                ) {
                    Text(
                        text = "Перемешать",
                        fontSize = 18.sp,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                        color = white,
                        fontFamily = RobotoMedium,
                        modifier = Modifier.padding(start = 16.dp, end = 16.dp)
                    )
                }
            }
        }
    }
}

@ExperimentalMaterialApi
fun getBottomState(id: Int): ModalBottomSheetValue {
    return if (id != -1) {
        ModalBottomSheetValue.Expanded
    } else {
        ModalBottomSheetValue.Hidden
    }
}