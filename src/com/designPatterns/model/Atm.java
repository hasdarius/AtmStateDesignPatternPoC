package com.designPatterns.model;

import com.designPatterns.sate.AtmState;
import com.designPatterns.sate.concreteStates.CardInsertedState;
import com.designPatterns.sate.concreteStates.IdleState;
import com.designPatterns.sate.concreteStates.PinInsertedState;
import com.designPatterns.sate.concreteStates.TransactionCompleteState;

public class Atm {
    private final Bank bank;
    private Account authenticatedAccount = null;
    private Card introducedCard = null;
    private AtmState state;
    private final AtmState idleState;
    private final AtmState cardInsertedState;
    private final AtmState pinInsertedState;
    private final AtmState transactionCompleteState;

    private Integer atmBalance;

    public Atm(Integer moneyAmount) {
        bank = Bank.getInstance();
        this.atmBalance = moneyAmount;
        idleState = new IdleState(this);
        cardInsertedState = new CardInsertedState(this);
        pinInsertedState = new PinInsertedState(this);
        transactionCompleteState = new TransactionCompleteState(this);
        state = idleState;
    }

    public void addToAtmBalance(Integer moneyAmount) {
        atmBalance = atmBalance + moneyAmount;
    }

    public void removeFromAtmBalance(Integer moneyAmount) {
        atmBalance = atmBalance - moneyAmount;
    }

    public AtmState getState() {
        return state;
    }

    public void setState(AtmState state) {
        this.state = state;
        System.out.println("You are now in state " + state.getClass().getName());
    }

    public AtmState getIdleState() {
        return idleState;
    }

    public AtmState getCardInsertedState() {
        return cardInsertedState;
    }

    public AtmState getPinInsertedState() {
        return pinInsertedState;
    }

    public AtmState getTransactionCompleteState() {
        return transactionCompleteState;
    }

    public Account getAuthenticatedAccount() {
        return authenticatedAccount;
    }

    public void setAuthenticatedAccount(Account authenticatedAccount) {
        this.authenticatedAccount = authenticatedAccount;
    }

    public Bank getBank() {
        return bank;
    }

    public Card getIntroducedCard() {
        return introducedCard;
    }

    public void setIntroducedCard(Card introducedCard) {
        this.introducedCard = introducedCard;
    }

    public Integer getAtmBalance() {
        return atmBalance;
    }

    public void insertCard(Card card) {
        state.insertCard(card);
    }

    public void insertPin(String pin) {
        state.insertPin(pin);
    }


    public void ejectCard(Card card) {
        state.ejectCard(card, this);
    }


    public void changePin(String oldPin, String newPin) {
        state.changePin(oldPin, newPin);
    }


    public void checkAccountBalance() {
        state.checkAccountBalance();
    }


    public void withdrawMoney(Integer amount) {
        state.withdrawMoney(amount);
    }


    public void depositMoney(Integer amount) {
        state.depositMoney(amount);
    }


    public void performAnotherTransaction(Boolean option) {
        state.performAnotherTransaction(option);

    }

}
