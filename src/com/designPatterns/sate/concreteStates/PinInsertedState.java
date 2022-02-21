package com.designPatterns.sate.concreteStates;

import com.designPatterns.model.Atm;
import com.designPatterns.model.Card;
import com.designPatterns.sate.AtmState;

public record PinInsertedState(Atm atm) implements AtmState {

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
        if (oldPin.equals(atm.getAuthenticatedAccount().getCard().getPin())) {
            System.out.println("Old pin introduced correctly. Changing pin...");
            atm.getBank().updatePin(atm.getAuthenticatedAccount(), newPin);
            System.out.println("Pin change successful. De-authenticating for security reasons...");
            atm.setAuthenticatedAccount(null);
            atm.setState(atm.getCardInsertedState());
        } else {
            System.out.println("Old pin incorrect. Please try again.");
        }
    }

    @Override
    public void checkAccountBalance() {
        System.out.println("Your account balance is: " + atm.getAuthenticatedAccount().getBalance());
        atm.setState(atm.getTransactionCompleteState());
    }

    @Override
    public void withdrawMoney(Integer amount) {
        Integer previousBalance = atm.getAuthenticatedAccount().getBalance().get();
        atm.getAuthenticatedAccount().addToOrRemoveFromAccountBalance(-amount);
        Integer newBalance = atm.getAuthenticatedAccount().getBalance().get();
        if (previousBalance.equals(newBalance)) {
            System.out.println("Transaction failed. Insufficient funds in account.");
        } else {
            if (atm.getAtmBalance() < amount) {
                System.out.println("Transaction failed. Insufficient funds in ATM.");
                atm.getAuthenticatedAccount().addToOrRemoveFromAccountBalance(amount);
            } else {
                atm.removeFromAtmBalance(amount);
                System.out.println("Transaction successful. Please collect the money.");
            }
        }
        atm.setState(atm.getTransactionCompleteState());
    }

    @Override
    public void insertMoney(Integer amount) {
        System.out.println("Money received. Perfoming transaction...");
        atm.getAuthenticatedAccount().addToOrRemoveFromAccountBalance(amount);
        atm.addToAtmBalance(amount);
        System.out.println("Transaction successful.");
        atm.setState(atm.getTransactionCompleteState());
    }

    @Override
    public void performAnotherTransaction(Boolean option) {
        System.out.println("Please select a valid transaction to perform...");
    }
}
