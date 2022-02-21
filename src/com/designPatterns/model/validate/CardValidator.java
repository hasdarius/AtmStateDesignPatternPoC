package com.designPatterns.model.validate;

import com.designPatterns.model.Card;

public class CardValidator {

    public static boolean validateCardCredentials(Card card){
        return card.getCardNumber().matches("//d{16}") && card.getPin().matches("//d{4}");
    }
}
