package com.lld.blackjack.cards;

public class NumberCard extends Card{
    public NumberCard(CardSuite cardSuite, int value) {
        super(cardSuite, value);
        this.cardType = CardType.NUMBER_CARD;
    }
}
