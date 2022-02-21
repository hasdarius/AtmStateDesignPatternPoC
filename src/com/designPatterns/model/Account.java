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

    /**
     *
     * @param amount
     * Method used for both adding to account balance or removing from it. Implemented in a thread safe way.
     */
    public synchronized void addToOrRemoveFromAccountBalance(Integer amount) {
        if (balance.get() + amount > 0) {
            balance.addAndGet(amount);
        }
    }

    public String getAccountNumber() {
        return accountNumber;
    }
}
