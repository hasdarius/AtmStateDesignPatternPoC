package com.designPatterns.sate.concreteStates;

import com.designPatterns.model.Atm;
import com.designPatterns.model.Card;
import com.designPatterns.sate.AtmState;

public record TransactionCompleteState(Atm atm) implements AtmState {

    @Override
    public void insertCard(Card card) {
        System.out.println("Card already inserted. Cannot insert another one...");
    }

    @Override
    public void insertPin(String pin) {
        System.out.println("Pin already inserted. Cannot insert another one...");
    }


    @Override
    public void changePin(String oldPin, String newPin) {
        System.out.println("Another transaction was just completed. Please select 'Perform another transaction' option if you wish to perform this task...");
    }

    @Override
    public void checkAccountBalance() {
        System.out.println("Another transaction was just completed. Please select 'Perform another transaction' option if you wish to perform this task...");
    }

    @Override
    public void withdrawMoney(Integer amount) {
        System.out.println("Another transaction was just completed. Please select 'Perform another transaction' option if you wish to perform this task...");
    }

    @Override
    public void insertMoney(Integer amount) {
        System.out.println("Another transaction was just completed. Please select 'Perform another transaction' option if you wish to perform this task...");

    }

    @Override
    public void performAnotherTransaction(Boolean option) {
        atm.setState(atm.getPinInsertedState());
    }
}
