package com.lld.blackjack.accounts;

import com.lld.blackjack.cards.Card;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public abstract class Account {
    private final String ID;
    private String username;
    private String password;
    private List<Card> cards;

    public Account(String username,String password){
        this.ID = UUID.randomUUID().toString();
        this.username = username;
        this.password = password;
        this.cards = new ArrayList<>();
    }

    public void addCard(Card card){
        this.cards.add(card);
    }

    public String getID() {
        return ID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Card> getCards() {
        return cards;
    }

    public void setCards(List<Card> cards) {
        this.cards = cards;
    }
}
