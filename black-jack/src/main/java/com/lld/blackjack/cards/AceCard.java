package com.lld.blackjack.cards;

public class AceCard extends Card{

    private final int secondaryValue;

    public AceCard(CardSuite cardSuite) {
        super(cardSuite, 1);
        this.secondaryValue = 11;
        this.cardType = CardType.ACE_CARD;
    }

    public int getSecondaryValue() {
        return secondaryValue;
    }
}
