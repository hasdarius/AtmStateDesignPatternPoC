package com.designPatterns.sate;

import com.designPatterns.model.Card;

public interface AtmState {
    public void insertCard(Card card);
    public void insertPin(String pin);
    public void ejectCard(Card card);
    public void changePin(String oldPin, String newPin);
    public void checkAccountBalance();
    public void withdrawMoney(Integer amount);
    public void insertMoney(Integer amount);
    public void performAnotherTransaction(Boolean option);
}
