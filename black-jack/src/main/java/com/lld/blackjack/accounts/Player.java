package com.lld.blackjack.accounts;

public class Player extends Account{

    private double cash;

    public Player(String username, String password, double cash) {
        super(username, password);
        this.cash = cash;
    }

    public double getCash() {
        return cash;
    }

    public void setCash(double cash) {
        this.cash = cash;
    }
}
