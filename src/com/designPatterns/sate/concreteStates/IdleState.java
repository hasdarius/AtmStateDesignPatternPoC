package com.designPatterns.sate.concreteStates;

import com.designPatterns.model.Atm;
import com.designPatterns.model.Card;
import com.designPatterns.model.validate.CardValidator;
import com.designPatterns.sate.AtmState;

public record IdleState(Atm atm) implements AtmState {

    @Override
    public void insertCard(Card card) {
        System.out.println("Card inserted. Validating...");
        if (CardValidator.validateCardCredentials(card)) {
            System.out.println("Card Validated");
            atm.setState(atm.getCardInsertedState());
        } else {
            System.out.println("Card credeltials invalid...");
        }
    }

    @Override
    public void insertPin(String pin) {
        System.out.println("Card not inserted. Cannot insert Pin.");
    }


    @Override
    public void changePin(String oldPin, String newPin) {
        System.out.println("Card not inserted. Cannot change Pin.");

    }

    @Override
    public void checkAccountBalance() {
        System.out.println("Card not inserted. Cannot check account balance.");

    }

    @Override
    public void withdrawMoney(Integer amount) {
        System.out.println("Card not inserted. Cannot withdraw money.");

    }

    @Override
    public void insertMoney(Integer amount) {
        System.out.println("Card not inserted. Cannot insert money.");

    }

    @Override
    public void performAnotherTransaction(Boolean option) {
        System.out.println("Card not inserted. Cannot perform another transaction.");

    }
}
