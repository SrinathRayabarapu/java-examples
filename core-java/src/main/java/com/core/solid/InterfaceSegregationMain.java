package com.core.solid;

import lombok.extern.slf4j.Slf4j;

/**
 * Client should not be forced to implement unnecessary methods which they will not use
 *
 * ISP is applicable to interfaces as a single responsibility principle holds to classes
 * ISP states that we should split our interfaces into smaller and more specific ones
 *
 */
public class InterfaceSegregationMain {

    public static void main(String[] args) {

    }

}

// split based on the responsibility - similarly other interfaces needs to be derived from the below
interface OnlinePizzaApp {
    void acceptOnlineOrders();
    void acceptOnlinePayments();
}

@Slf4j
class SrinathOnlinePizzaApp implements OnlinePizzaApp {

    @Override
    public void acceptOnlineOrders() {
      log.info("Online order accepted!");
    }

    @Override
    public void acceptOnlinePayments() {
        log.info("Online payment is completed!");
    }
}


// bad design to keep all types of orders and payments in single interface
interface PizzaAppBad {

    void acceptOnlineOrders();

    void acceptWalkInOrders();

    void acceptTelephoneOrders();

    void acceptOnlinePayments();

    void acceptCashPayments();

}

class SrinathPizzaAppBad implements PizzaAppBad {

    @Override
    public void acceptOnlineOrders() {

    }

    @Override
    public void acceptWalkInOrders() {

    }

    @Override
    public void acceptTelephoneOrders() {

    }

    @Override
    public void acceptOnlinePayments() {

    }

    @Override
    public void acceptCashPayments() {

    }
}