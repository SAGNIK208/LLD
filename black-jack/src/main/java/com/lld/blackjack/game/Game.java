package com.lld.blackjack.game;


import com.lld.blackjack.accounts.Account;
import com.lld.blackjack.accounts.Dealer;
import com.lld.blackjack.accounts.Player;
import com.lld.blackjack.cards.Card;
import com.lld.blackjack.cards.CardType;
import com.lld.blackjack.cards.Deck;
import com.lld.blackjack.game.GameActions.PlayerActions;

import java.util.List;
import java.util.Random;
import java.util.Scanner;


public class Game {
    private static Game INSTANCE;
    private Player player;
    private Dealer dealer;
    private Deck deck;
    private Random random;
    private Scanner sc;

    private Game() {
        random = new Random();
    }

    public static Game getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new Game();
        }
        return INSTANCE;
    }

    public void init(Player player, Dealer dealer, Scanner sc) {
        this.player = player;
        PlayerActions.addPlayer(player);
        this.dealer = dealer;
        this.deck = new Deck();
        this.sc = sc;
    }

    public void startGame(Scanner sc) {
        while (true) {
            System.out.println("Place Initial Bet");
            double bet = sc.nextDouble();
            boolean betPlaced = PlayerActions.placeInitialBet(bet);
            if (betPlaced) {
                initialCards();
                boolean isInsuranceBetApplicable = dealer.getCards().get(0).getCardType() == CardType.ACE_CARD;
                if (isInsuranceBetApplicable) {
                    insuranceBetScenarios();
                }
                boolean isBlackJack = blackJackScenarios();
                if (isBlackJack) {
                    clearRound();
                } else {
                    nonBlackJackScenarios();
                    clearRound();
                }
            } else {
                System.out.println("Amount not Available press 1 to change bet or any other key to stop");
                int key = sc.nextInt();
                if (key != 1) {
                    clearRound();
                } else {
                    clearGame();
                    return;
                }
            }
        }
    }

    private void nonBlackJackScenarios() {
        /*
            player chooses:
                1. stand
                    dealer chooses:
                        while(notBurst && value < 17)
                            dealer picks
                         if(dealer.value > player.value)
                            player looses
                         else
                            player gains +mainBet
                2. hit
                    player picks
                        if(burst)
                            player looses
                        else
                            same as stand
                3. double
                    player doubles bet
                    same as hit
        */
        int key = 0;
        while (key != 1 && key != 2 && key != 3) {
            System.out.println("Choose one of the three options 1 to stand 2 to hit 3 to double any other key is not allowed");
            key = sc.nextInt();
        }
        boolean burst = false;
        switch (key) {
            case 1:
                PlayerActions.stand();
                break;
            case 2:
                PlayerActions.hit();
                if (checkBurst(player.getCards())) burst = true;
                break;
            case 3:
                boolean isDoublePossible = PlayerActions.doubleBet();
                if(!isDoublePossible){
                    System.out.println("As Double amount is not available going with hit option");
                    PlayerActions.hit();
                }
                if(checkBurst(player.getCards())) burst = true;
        }
        if(!burst)
            dealerActions();
    }

    private boolean checkBurst(List<Card> cards) {
        return PointCalculationSystem.calculateHardHandPoints(cards) > 21;
    }

    //TODO : get value and checkBurst needs to be checked currently its faulty as we are hardcoding hard in checkBurst and soft in getValue
    private int getValue(Account acc) {
        return PointCalculationSystem.calculateSoftHandPoints(acc.getCards());
    }

    private void dealerActions() {
        double mainBet = PlayerActions.getBetAmount();
        while (!checkBurst(dealer.getCards()) && getValue(dealer) < 17) {
            dealer.addCard(pickCard());
            if (checkBurst(dealer.getCards())) {
                PlayerActions.updateCash(mainBet);
                return;
            }
        }
        if (getValue(player) > getValue(dealer)) PlayerActions.updateCash(mainBet);
    }


    private boolean blackJackScenarios() {
       /*
            insurance bet taken
                dealer blackJack + player backJack = main bet amount + 2 * insurance bet
                dealer blackJack = 2 * insurance bet
                player blackJack = 1.5 * main bet amount
            insurance bet not taken
                dealer blackJack + player backJack = main amount
                dealer blackJack = 0
                player blackJack = 1.5 main amount
        */
        double mainBet = PlayerActions.getBetAmount();
        boolean isDealerBlackJack = isBlackJack(dealer.getCards());
        boolean isPlayerBlackJack = isBlackJack(player.getCards());
        if (PlayerActions.isInsuranceBetPresent()) {
            double insuranceBet = PlayerActions.getInsuranceBet();
            if (isDealerBlackJack && isPlayerBlackJack) PlayerActions.updateCash(mainBet + 2 * insuranceBet);
            else if (isDealerBlackJack) PlayerActions.updateCash(2 * insuranceBet);
            else if (isPlayerBlackJack) PlayerActions.updateCash(1.5 * mainBet);
        } else {
            if (isDealerBlackJack && isPlayerBlackJack) PlayerActions.updateCash(mainBet);
            else if (isDealerBlackJack) PlayerActions.updateCash(0);
            else if (isPlayerBlackJack) PlayerActions.updateCash(1.5 * mainBet);
        }
        return isDealerBlackJack || isPlayerBlackJack;
    }

    private void insuranceBetScenarios() {
        System.out.println("Insurance Bet press 1 to take any other key to ignore");
        int insuranceBetTaken = sc.nextInt();
        if (insuranceBetTaken == 1) {
            boolean isInsuranceBetPossible = PlayerActions.takeInsuranceBet();
            if (!isInsuranceBetPossible) {
                System.out.println("Amount not available so insurance bet was not given");
            }
        } else {
            System.out.println("Insurance Bet was not taken");
        }
    }

    private void initialCards() {
        dealer.addCard(pickCard());
        dealer.addCard(pickCard());
        player.addCard(pickCard());
        player.addCard(pickCard());
    }

    public Card pickCard() {
        int index = random.nextInt(52);
        return deck.getCard(index);
    }

    public boolean isBlackJack(List<Card> cards) {
        return PointCalculationSystem.calculateSoftHandPoints(cards) == 21;
    }

    public void clearRound() {
        deck = new Deck();
        System.out.println("Cash remaining =" + player.getCash());
        PlayerActions.clearRound();
    }

    public void clearGame() {
        System.out.println("Thank you for playing");
        PlayerActions.clearGame();
    }

}
