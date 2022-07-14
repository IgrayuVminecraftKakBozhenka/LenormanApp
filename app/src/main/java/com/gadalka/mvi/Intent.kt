package com.gadalka.mvi

sealed class Intent {
    class OnCardClick(val id: Int) : Intent()
    class CardDescriptionClick(val id: Int) : Intent()
    object ShuffleCards : Intent()
    object ClearDescriptions : Intent()
}
