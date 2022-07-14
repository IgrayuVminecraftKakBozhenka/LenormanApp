package com.gadalka.mvi

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gadalka.models.CardModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ViewModel(
    state: State
): ViewModel() {
    private val _state: MutableStateFlow<State> = MutableStateFlow(state)
    val state: StateFlow<State> = _state

    private val cards = listOf(
        CardModel(
            id = 1,
            cardName = "Всадник"
        ),
        CardModel(
            id = 2,
            cardName = "Клевер"
        ),
        CardModel(
            id = 3,
            cardName = "Корабль"
        ),
        CardModel(
            id = 4,
            cardName = "Дом"
        ),
        CardModel(
            id = 5,
            cardName = "Дерево"
        ),
        CardModel(
            id = 6,
            cardName = "Тучи"
        ),
        CardModel(
            id = 7,
            cardName = "Змея"
        ),
        CardModel(
            id = 8,
            cardName = "Гроб"
        ),
        CardModel(
            id = 9,
            cardName = "Букет"
        ),
        CardModel(
            id = 10,
            cardName = "Коса"
        ),
        CardModel(
            id = 11,
            cardName = "Метла"
        ),
        CardModel(
            id = 12,
            cardName = "Совы"
        ),
        CardModel(
            id = 13,
            cardName = "Ребёнок"
        ),
        CardModel(
            id = 14,
            cardName = "Лиса"
        ),
        CardModel(
            id = 15,
            cardName = "Медведь"
        ),
        CardModel(
            id = 16,
            cardName = "Звезды"
        ),
        CardModel(
            id = 17,
            cardName = "Аист"
        ),
        CardModel(
            id = 18,
            cardName = "Собака"
        ),
        CardModel(
            id = 19,
            cardName = "Башня"
        ),
        CardModel(
            id = 20,
            cardName = "Сад"
        ),
        CardModel(
            id = 21,
            cardName = "Гора"
        ),
        CardModel(
            id = 22,
            cardName = "Развилка"
        ),
        CardModel(
            id = 23,
            cardName = "Крысы"
        ),
        CardModel(
            id = 24,
            cardName = "Сердце"
        ),
        CardModel(
            id = 25,
            cardName = "Кольцо"
        ),
        CardModel(
            id = 26,
            cardName = "Книга"
        ),
        CardModel(
            id = 27,
            cardName = "Письмо"
        ),
        CardModel(
            id = 28,
            cardName = "Мужик"
        ),
        CardModel(
            id = 29,
            cardName = "Женщина"
        ),
        CardModel(
            id = 30,
            cardName = "Лилии"
        ),
        CardModel(
            id = 31,
            cardName = "Солнце"
        ),
        CardModel(
            id = 32,
            cardName = "Луна"
        ),
        CardModel(
            id = 33,
            cardName = "Ключь"
        ),
        CardModel(
            id = 34,
            cardName = "Рыбы"
        ),
        CardModel(
            id = 35,
            cardName = "Якорь"
        ),
        CardModel(
            id = 36,
            cardName = "Крест"
        ),
    )

    init {
        _state.value = state.copy(allCards = (cards.shuffled() as ArrayList<CardModel>))
    }

    fun performIntent(intent: Intent) {
        when (intent) {
            is Intent.OnCardClick -> onCardClick(intent.id)
            Intent.ShuffleCards -> shuffleCards()
            is Intent.CardDescriptionClick -> cardDescriptionClick(intent.id)
            Intent.ClearDescriptions -> clearDescription()
        }
    }

    private fun onCardClick(id: Int) {
        val card = findCard(id)

        when {
            _state.value.firstCard.id == -1 -> {
                val index =  _state.value.allCards.indexOf(card)
                val allCards = _state.value.allCards
                allCards.removeAt(index)
                _state.value = _state.value.copy(firstCard = card, allCards = allCards)
            }
            _state.value.secondCard.id == -1 -> {
                val index =  _state.value.allCards.indexOf(card)
                val allCards = _state.value.allCards
                allCards.removeAt(index)
                _state.value = _state.value.copy(secondCard = card, allCards = allCards)
            }
            _state.value.thirdCard.id == -1 -> {
                val index =  _state.value.allCards.indexOf(card)
                val allCards = _state.value.allCards
                allCards.removeAt(index)
                _state.value = _state.value.copy(thirdCard = card, allCards = allCards)
            }
        }

    }

    private fun shuffleCards() {
        viewModelScope.launch {
            _state.value = _state.value.copy(
                allCards = (cards.shuffled() as ArrayList<CardModel>),
                firstCard = CardModel(),
                secondCard = CardModel(),
                thirdCard = CardModel(),
                offset = 1
            )

            delay(500L)
            _state.value = _state.value.copy(offset = 0)
        }
    }

    private fun cardDescriptionClick(id: Int) {
        val description = cards.find { it.id == id }?.description ?: return
        _state.value = _state.value.copy(actualCardDescription = description, bottomSheetShown = true)
    }

    private fun clearDescription() {
        _state.value = _state.value.copy(actualCardDescription = "", bottomSheetShown = false)
    }

    private fun findCard(id: Int): CardModel = _state.value.allCards.find {
        it.id == id
    }!!
}