package com.lld.blackjack.cards;

public abstract class Card {
    private final CardSuite cardSuite;
    private final int value;
    protected CardType cardType;

    public Card(CardSuite cardSuite, int value){
        this.cardSuite = cardSuite;
        this.value = value;
    }

    public CardType getCardType() {
        return cardType;
    }

    public CardSuite getCardSuite() {
        return cardSuite;
    }

    public int getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "Card{" +
                "cardSuite=" + cardSuite +
                ", value=" + value +
                ", cardType=" + cardType +
                '}';
    }
}
