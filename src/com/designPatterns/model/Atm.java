package com.designPatterns.model;

import com.designPatterns.sate.AtmState;
import com.designPatterns.sate.concreteStates.CardInsertedState;
import com.designPatterns.sate.concreteStates.IdleState;
import com.designPatterns.sate.concreteStates.PinInsertedState;
import com.designPatterns.sate.concreteStates.TransactionCompleteState;

import java.util.concurrent.atomic.AtomicInteger;

public class Atm {
    Bank bank;
    AtmState state;
    AtmState idleState;
    AtmState cardInsertedState;
    AtmState pinInsertedState;
    AtmState transactionCompleteState;

    private AtomicInteger moneyAmount;

    public Atm(Integer moneyAmount) {
        bank = Bank.getInstance();
        this.moneyAmount = new AtomicInteger(moneyAmount);
        idleState = new IdleState(this);
        cardInsertedState = new CardInsertedState(this);
        pinInsertedState = new PinInsertedState(this);
        transactionCompleteState = new TransactionCompleteState(this);
        state = idleState;
    }

    private void refillAtm(Integer moneyAmount){
        this.moneyAmount.addAndGet(moneyAmount);
    }

    public AtmState getState() {
        return state;
    }

    public void setState(AtmState state) {
        this.state = state;
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

    public AtomicInteger getMoneyAmount() {
        return moneyAmount;
    }
    public void insertCard(Card card){
        state.insertCard(card);
    }
    public void insertPin(String pin){
        state.insertPin(pin);
    };
    public void ejectCard(Card card){
        state.ejectCard(card);
    };
    public void changePin(String oldPin, String newPin){
        state.changePin(oldPin, newPin);
    };
    public void checkAccountBalance(){
        state.checkAccountBalance();
    };
    public void withdrawMoney(Integer amount){
        state.withdrawMoney(amount);
    };
    public void insertMoney(Integer amount){
        state.insertMoney(amount);
    };
    public void performAnotherTransaction(Boolean option){
        state.performAnotherTransaction(option);

    };
}
