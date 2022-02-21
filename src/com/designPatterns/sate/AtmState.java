package com.designPatterns.sate;

import com.designPatterns.model.Atm;
import com.designPatterns.model.Card;

public interface AtmState {
    void insertCard(Card card);

    void insertPin(String pin);

    void changePin(String oldPin, String newPin);

    void checkAccountBalance();

    void withdrawMoney(Integer amount);

    void insertMoney(Integer amount);

    void performAnotherTransaction(Boolean option);

    default void ejectCard(Card card, Atm atm) {
        System.out.println("Ejecting card...");
        atm.setIntroducedCard(null);
        atm.setAuthenticatedAccount(null);
        atm.setState(atm.getIdleState());
    }
}
