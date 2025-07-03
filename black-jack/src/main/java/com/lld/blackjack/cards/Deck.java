package com.lld.blackjack.cards;

import java.util.ArrayList;
import java.util.List;

public class Deck {
    private final List<Card> cards;

    public Deck(){
        this.cards = new ArrayList<>();
        for(int i = 2; i <= 10; i++){
           for(CardSuite cardSuite : CardSuite.values()){
               this.cards.add(new NumberCard(cardSuite,i));
           }
        }
        for(FaceCardType faceCardType : FaceCardType.values()){
            for(CardSuite cardSuite : CardSuite.values()){
                this.cards.add(new FaceCard(cardSuite,faceCardType));
            }
        }
        for(CardSuite cardSuite : CardSuite.values()){
            this.cards.add(new AceCard(cardSuite));
        }
    }

    public List<Card> getCards() {
        return this.cards;
    }

    public Card getCard(int index){
        Card card =  this.cards.get(index);
        this.cards.remove(card);
        return card;
    }
}
