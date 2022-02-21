package com.designPatterns.sate.concreteStates;

import com.designPatterns.model.Account;
import com.designPatterns.model.Atm;
import com.designPatterns.model.Bank;
import com.designPatterns.model.Card;
import com.designPatterns.sate.AtmState;

import java.util.Objects;
import java.util.Optional;

public record CardInsertedState(Atm atm) implements AtmState {

    @Override
    public void insertCard(Card card) {
        System.out.println("Card already inserted. Cannot insert another one...");
    }

    @Override
    public void insertPin(String pin) {
        System.out.println("Pin Introduced. Validating...");
        Optional<Account> account = atm.getBank().getAccount(atm.getIntroducedCard());
        if (account.isPresent() && Objects.equals(pin, atm.getIntroducedCard().getPin())) {
            System.out.println("Pin correct. Authenticated.");
            atm.setAuthenticatedAccount(account.get());
            atm.setState(atm.getPinInsertedState());
        } else {
            System.out.println("Account does not exist");
        }
    }


    @Override
    public void changePin(String oldPin, String newPin) {
        System.out.println("Not authenticated. Cannot change Pin.");

    }

    @Override
    public void checkAccountBalance() {
        System.out.println("Not authenticated. Cannot check account balance.");

    }

    @Override
    public void withdrawMoney(Integer amount) {
        System.out.println("Not authenticated. Cannot withdraw money.");

    }

    @Override
    public void insertMoney(Integer amount) {
        System.out.println("Not authenticated. Cannot insert money.");

    }

    @Override
    public void performAnotherTransaction(Boolean option) {
        System.out.println("Not authenticated. Cannot perform another transaction.");

    }
}
