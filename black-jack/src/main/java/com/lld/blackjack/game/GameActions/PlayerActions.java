package com.lld.blackjack.game.GameActions;

import com.lld.blackjack.accounts.Player;
import com.lld.blackjack.cards.Card;
import com.lld.blackjack.game.Game;

public class PlayerActions {

    private static double betAmount = 0;
    private static double insuranceBet = 0;
    private final static int INSURANCE_BET_FACTOR = 2;
    private static boolean insuranceTaken = false;
    private static Player player;

    public static void addPlayer(Player player){
        PlayerActions.player = player;
    }

    public static boolean placeInitialBet(double bet){
        if(player.getCash() < bet){
            return false;
        }
        player.setCash(player.getCash() - PlayerActions.betAmount);
        PlayerActions.betAmount = bet;
        PlayerActions.insuranceBet = betAmount / INSURANCE_BET_FACTOR;
        return true;
    }
    public static void hit(){
        Card card = Game.getInstance().pickCard();
        System.out.println(card);
        player.addCard(card);
    }

    public static boolean doubleBet(){
        if(player.getCash() < PlayerActions.betAmount){
            return false;
        }
        PlayerActions.betAmount *= 2;
        player.setCash(player.getCash() - PlayerActions.betAmount);
        hit();
        return true;
    }

    public static void stand(){
        //do nothing
    }

    public static boolean takeInsuranceBet(){
        if(player.getCash() < insuranceBet){
            return false;
        }
        player.setCash(player.getCash() - PlayerActions.insuranceBet);
        insuranceTaken = true;
        return true;
    }

    public static boolean isInsuranceBetPresent(){
        return PlayerActions.insuranceTaken;
    }

    public static double getBetAmount(){
        return PlayerActions.betAmount;
    }

    public static double getInsuranceBet(){
        return PlayerActions.insuranceBet;
    }

    public static void updateCash(double amount){
        player.setCash(player.getCash() + amount);
    }

    public static void clearRound(){
        betAmount = 0;
        insuranceBet = 0;
    }

    public static void clearGame(){
        clearRound();
        player = null;
    }
}
