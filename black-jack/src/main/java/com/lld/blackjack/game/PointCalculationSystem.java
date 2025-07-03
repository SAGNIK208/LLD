package com.lld.blackjack.game;

import com.lld.blackjack.cards.AceCard;
import com.lld.blackjack.cards.Card;
import com.lld.blackjack.cards.CardType;

import java.util.List;

public class PointCalculationSystem {
    public static int calculateSoftHandPoints(List<Card> cards){
        int softHandPoints = 0;
        for(Card card : cards){
            if(card.getCardType() == CardType.ACE_CARD){
                softHandPoints += ((AceCard) card).getSecondaryValue();
            }else{
                softHandPoints += card.getValue();
            }
        }
        return softHandPoints;
    }
    public static int calculateHardHandPoints(List<Card> cards){
        int hardHandPoints = 0;
        for(Card card : cards){
            hardHandPoints += card.getValue();
        }
        return hardHandPoints;
    }
}
