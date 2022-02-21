package com.designPatterns.sate.concreteStates;

import com.designPatterns.model.Atm;
import com.designPatterns.model.Card;
import com.designPatterns.model.validate.CardValidator;
import com.designPatterns.sate.AtmState;

public class IdleState implements AtmState {
    Atm atm;

    public IdleState(Atm atm) {
        this.atm = atm;
    }

    @Override
    public void insertCard(Card card) {
        System.out.println("Card inserted. Validating...");
        if(CardValidator.validateCardCredentials(card)){
            System.out.println("Card Validated");
            atm.setState(atm.getCardInsertedState());
        }
    }

    @Override
    public void insertPin(String pin) {

    }

    @Override
    public void ejectCard(Card card) {

    }

    @Override
    public void changePin(String oldPin, String newPin) {

    }

    @Override
    public void checkAccountBalance() {

    }

    @Override
    public void withdrawMoney(Integer amount) {

    }

    @Override
    public void insertMoney(Integer amount) {

    }

    @Override
    public void performAnotherTransaction(Boolean option) {

    }
}
