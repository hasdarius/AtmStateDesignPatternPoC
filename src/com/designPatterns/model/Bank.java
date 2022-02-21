package com.designPatterns.model;

import com.designPatterns.model.validate.CardValidator;

import java.util.LinkedHashSet;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.Set;

public class Bank {
    Set<Account> accounts;

    private Bank() {
        accounts = new LinkedHashSet<>();
    }

    public void updatePin(Account account, String pin) {
        accounts.remove(account);
        account.setCard(new Card(account.getCard().getCardNumber(), pin));
        accounts.add(account);
    }

    private static final class BankHolder {
        private static final Bank bank = new Bank();
    }

    public static Bank getInstance() {
        return BankHolder.bank;
    }

    public void addAccount(Account account) {
        if (CardValidator.validateCardCredentials(account.getCard())) {
            accounts.add(account);
        }
    }

    public Optional<Account> getAccount(Card card) {
        return accounts.stream()
                .filter(account -> account.getCard().equals(card))
                .findFirst();
    }
}
