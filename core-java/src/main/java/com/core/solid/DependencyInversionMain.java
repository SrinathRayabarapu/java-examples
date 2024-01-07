package com.core.solid;

import lombok.extern.slf4j.Slf4j;

/**
 * Depend on the abstractions(abstract class or interface), not on concretions
 *
 * Design in such away that various modules can be separated from each other using an abstract layer to bind them together
 *
 */
public class DependencyInversionMain {

    public static void main(String[] args) {
        BankCard bankCard = new CreditCard();

        ShoppingMall shoppingMall = new ShoppingMall(bankCard);
        shoppingMall.makePaymentForShopping();
    }
}

class ShoppingMall {

    // depending on concrete implementations introduces tight coupling
//    CreditCard creditCard;
//    DebitCard debitCard;

    // instead depend on abstractions
    BankCard bankCard;

    public ShoppingMall(BankCard bankCard) {
        this.bankCard = bankCard;
    }

    public void makePaymentForShopping(){
        bankCard.doPayment();
    }
}

@Slf4j
class CreditCard implements BankCard {
    public void doPayment(){
        log.info("Paying through Credit card");
    }
}

@Slf4j
class DebitCard implements BankCard {
    public void doPayment(){
        log.info("Paying through Debit card");
    }
}

interface BankCard {
    void doPayment();
}
