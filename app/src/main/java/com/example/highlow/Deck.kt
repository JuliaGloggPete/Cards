package com.example.highlow

class Deck() {

    var listOfCard = mutableListOf<Card>()
    var listOfplayedCards = mutableListOf<Card>()
    lateinit var nextCard: Card
    lateinit var currentCard: Card

    init {
        createCards()

        listOfCard.shuffle()

    }

    fun createCards() {

        listOfCard.add(Card(14, "Spades", R.drawable.spades_ace))
        listOfCard.add(Card(13, "Spades", R.drawable.spades_king))
        listOfCard.add(Card(12, "Spades", R.drawable.spades_queen))
        listOfCard.add(Card(11, "Spades", R.drawable.spades_jack))
        listOfCard.add(Card(10, "Spades", R.drawable.spades10))
        listOfCard.add(Card(9, "Spades", R.drawable.spades9))
        listOfCard.add(Card(8, "Spades", R.drawable.spades8))
        listOfCard.add(Card(7, "Spades", R.drawable.spades7))
        listOfCard.add(Card(6, "Spades", R.drawable.spades6))
        listOfCard.add(Card(5, "Spades", R.drawable.spades5))
        listOfCard.add(Card(4, "Spades", R.drawable.spades4))
        listOfCard.add(Card(3, "Spades", R.drawable.spades3))
        listOfCard.add(Card(2, "Spades", R.drawable.spades2))
        listOfCard.add(Card(14, "Hearts", R.drawable.heartsace))
        listOfCard.add(Card(13, "Hearts", R.drawable.heartsking))
        listOfCard.add(Card(12, "Hearts", R.drawable.heartsqueen))
        listOfCard.add(Card(11, "Hearts", R.drawable.heartsjack))
        listOfCard.add(Card(10, "Hearts", R.drawable.hearts10))
        listOfCard.add(Card(9, "Hearts", R.drawable.hearts9))
        listOfCard.add(Card(8, "Hearts", R.drawable.hearts8))
        listOfCard.add(Card(7, "Hearts", R.drawable.hearts7))
        listOfCard.add(Card(6, "Hearts", R.drawable.hearts6))
        listOfCard.add(Card(5, "Hearts", R.drawable.hearts5))
        listOfCard.add(Card(4, "Hearts", R.drawable.hearts4))
        listOfCard.add(Card(3, "Hearts", R.drawable.hearts3))
        listOfCard.add(Card(2, "Hearts", R.drawable.hearts2))
        listOfCard.add(Card(14, "Diamonds", R.drawable.diamond1))
        listOfCard.add(Card(13, "Diamonds", R.drawable.diamond13))
        listOfCard.add(Card(12, "Diamonds", R.drawable.diamond12))
        listOfCard.add(Card(11, "Diamonds", R.drawable.diamond11))
        listOfCard.add(Card(10, "Diamonds", R.drawable.diamond10))
        listOfCard.add(Card(9, "Diamonds", R.drawable.diamond9))
        listOfCard.add(Card(8, "Diamonds", R.drawable.diamond8))
        listOfCard.add(Card(7, "Diamonds", R.drawable.diamond7))
        listOfCard.add(Card(6, "Diamonds", R.drawable.diamond6))
        listOfCard.add(Card(5, "Diamonds", R.drawable.diamond5))
        listOfCard.add(Card(4, "Diamonds", R.drawable.diamond4))
        listOfCard.add(Card(3, "Diamonds", R.drawable.diamond3))
        listOfCard.add(Card(2, "Diamonds", R.drawable.diamond2))
        listOfCard.add(Card(14, "Clubs", R.drawable.clubsace))
        listOfCard.add(Card(13, "Clubs", R.drawable.clubsking))
        listOfCard.add(Card(12, "Clubs", R.drawable.clubsqueen))
        listOfCard.add(Card(11, "Clubs", R.drawable.clubsjack))
        listOfCard.add(Card(10, "Clubs", R.drawable.clubs10))
        listOfCard.add(Card(9, "Clubs", R.drawable.clubs9))
        listOfCard.add(Card(8, "Clubs", R.drawable.clubs8))
        listOfCard.add(Card(7, "Clubs", R.drawable.clubs7))
        listOfCard.add(Card(6, "Clubs", R.drawable.clubs6))
        listOfCard.add(Card(5, "Clubs", R.drawable.clubs5))
        listOfCard.add(Card(4, "Clubs", R.drawable.clubs4))
        listOfCard.add(Card(3, "Clubs", R.drawable.clubs3))
        listOfCard.add(Card(2, "Clubs", R.drawable.clubs2))

    }

    fun drawCard(): Card {

        nextCard = listOfCard.removeAt(0)
        currentCard = listOfCard[0]

        listOfplayedCards.add(0, currentCard)

        return nextCard
    }


    fun newRound() {
        listOfplayedCards.shuffle()

        listOfCard.addAll(listOfplayedCards)
        listOfplayedCards.clear()

        listOfCard.shuffle()

    }


}

