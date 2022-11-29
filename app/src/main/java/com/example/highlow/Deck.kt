package com.example.highlow

class Deck()  {

    var cardList = mutableListOf<Card>()
   var garbageList = mutableListOf<Card>()
    lateinit var nextCard: Card
    lateinit var currentCard: Card

    init {
        createCards()

        cardList.shuffle()

    }

    fun createCards() {

        cardList.add(Card(14, "Spades", R.drawable.spades_ace))
        cardList.add(Card(13, "Spades", R.drawable.spades_king))
        cardList.add(Card(12, "Spades", R.drawable.spades_queen))
        cardList.add(Card(11, "Spades", R.drawable.spades_jack))
        cardList.add(Card(10, "Spades", R.drawable.spades10))
        cardList.add(Card(9, "Spades", R.drawable.spades9))
        cardList.add(Card(8, "Spades", R.drawable.spades8))
        cardList.add(Card(7, "Spades", R.drawable.spades7))
        cardList.add(Card(6, "Spades", R.drawable.spades6))
        cardList.add(Card(5, "Spades", R.drawable.spades5))
        cardList.add(Card(4, "Spades", R.drawable.spades4))
        cardList.add(Card(3, "Spades", R.drawable.spades3))
        cardList.add(Card(2, "Spades", R.drawable.spades2))
        cardList.add(Card(14, "Hearts", R.drawable.heartsace))
        cardList.add(Card(13, "Hearts", R.drawable.heartsking))
        cardList.add(Card(12, "Hearts", R.drawable.heartsqueen))
        cardList.add(Card(11, "Hearts", R.drawable.heartsjack))
        cardList.add(Card(10, "Hearts", R.drawable.hearts10))
        cardList.add(Card(9, "Hearts", R.drawable.hearts9))
        cardList.add(Card(8, "Hearts", R.drawable.hearts8))
        cardList.add(Card(7, "Hearts", R.drawable.hearts7))
        cardList.add(Card(6, "Hearts", R.drawable.hearts6))
        cardList.add(Card(5, "Hearts", R.drawable.hearts5))
        cardList.add(Card(4, "Hearts", R.drawable.hearts4))
        cardList.add(Card(3, "Hearts", R.drawable.hearts3))
        cardList.add(Card(2, "Hearts", R.drawable.hearts2))
        cardList.add(Card(14, "Diamonds", R.drawable.diamond1))
        cardList.add(Card(13, "Diamonds", R.drawable.diamond13))
        cardList.add(Card(12, "Diamonds", R.drawable.diamond12))
        cardList.add(Card(11, "Diamonds", R.drawable.diamond11))
        cardList.add(Card(10, "Diamonds", R.drawable.diamond10))
        cardList.add(Card(9, "Diamonds", R.drawable.diamond9))
        cardList.add(Card(8, "Diamonds", R.drawable.diamond8))
        cardList.add(Card(7, "Diamonds", R.drawable.diamond7))
        cardList.add(Card(6, "Diamonds", R.drawable.diamond6))
        cardList.add(Card(5, "Diamonds", R.drawable.diamond5))
        cardList.add(Card(4, "Diamonds", R.drawable.diamond4))
        cardList.add(Card(3, "Diamonds", R.drawable.diamond3))
        cardList.add(Card(2, "Diamonds", R.drawable.diamond2))
        cardList.add(Card(14, "Clubs", R.drawable.clubsace))
        cardList.add(Card(13, "Clubs", R.drawable.clubsking))
        cardList.add(Card(12, "Clubs", R.drawable.clubsqueen))
        cardList.add(Card(11, "Clubs", R.drawable.clubsjack))
        cardList.add(Card(10, "Clubs", R.drawable.clubs10))
        cardList.add(Card(9, "Clubs", R.drawable.clubs9))
        cardList.add(Card(8, "Clubs", R.drawable.clubs8))
        cardList.add(Card(7, "Clubs", R.drawable.clubs7))
        cardList.add(Card(6, "Clubs", R.drawable.clubs6))
        cardList.add(Card(5, "Clubs", R.drawable.clubs5))
        cardList.add(Card(4, "Clubs", R.drawable.clubs4))
        cardList.add(Card(3, "Clubs", R.drawable.clubs3))
        cardList.add(Card(2, "Clubs", R.drawable.clubs2))

    }

    fun drawCard():Card {

        nextCard = cardList.removeAt(0)
        currentCard=cardList[0]

        garbageList.add(0,currentCard)

    return nextCard }


    fun newRound(){
        garbageList.shuffle()

        cardList.addAll(garbageList)
        garbageList.clear()

        cardList.shuffle()

    }



}

