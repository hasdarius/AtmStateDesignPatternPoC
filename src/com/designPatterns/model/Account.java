package com.designPatterns.model;

import java.util.concurrent.atomic.AtomicInteger;

public class Account {
    private final String accountHolderName;
    private final String accountNumber;
    private Card card;
    private AtomicInteger balance;


    public Account(String accountHolderName, String accountNumber, Card card, AtomicInteger balance) {
        this.accountHolderName = accountHolderName;
        this.accountNumber = accountNumber;
        this.card = card;
        this.balance = balance;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    public AtomicInteger getBalance() {
        return balance;
    }

    public void setBalance(AtomicInteger balance) {
        this.balance = balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }
}
