package com.lld.blackjack.cards;

public class FaceCard extends Card{
    private final FaceCardType faceCardType;
    public FaceCard(CardSuite cardSuite, FaceCardType faceCardType) {
        super(cardSuite, 10);
        this.faceCardType = faceCardType;
        this.cardType = CardType.FACE_CARD;
    }

    public FaceCardType getFaceCardType() {
        return faceCardType;
    }
}
