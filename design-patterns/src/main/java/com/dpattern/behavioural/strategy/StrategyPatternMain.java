package com.dpattern.behavioural.strategy;

import java.util.ArrayList;
import java.util.List;

/**
 * https://en.wikipedia.org/wiki/Strategy_pattern#Java
 * https://www.developer.com/java/data/implementing-strategy-patterns-in-java.html
 *
 * @author Srinath.Rayabarapu
 */
public class StrategyPatternMain {

    public static void main(String[] args) {

        // defining the strategies
        BillingStrategy normalStrategy = BillingStrategy.normalStrategy();
        BillingStrategy happyHoursStrategy = BillingStrategy.happyHoursStrategy();

        Customer firstCustomer = new Customer(normalStrategy);
        firstCustomer.add(100, 1);

        firstCustomer.setStrategy(happyHoursStrategy);
        firstCustomer.add(100, 2);

        Customer secondCustomer = new Customer(happyHoursStrategy);
        secondCustomer.add(80, 1);

        System.out.println("First customer bill : " + firstCustomer.getBill());

        secondCustomer.setStrategy(normalStrategy);
        secondCustomer.add(130, 2);
        secondCustomer.add(250, 1);
        System.out.println("Second customer bill : " + secondCustomer.getBill());

    }
    
}

/**
 * @author Srinath.Rayabarapu
 */
class Customer {

    private BillingStrategy billingStrategy;
    private final List<Integer> drinks = new ArrayList<>();

    public Customer(BillingStrategy strategy) {
        this.billingStrategy = strategy;
    }

    public void add(int amount, int quantity) {
        this.drinks.add(this.billingStrategy.getActPrice(amount*quantity));
    }

    public void setStrategy(BillingStrategy strategy) {
        this.billingStrategy = strategy;
    }

    public int getBill() {
        int sum = drinks.stream().mapToInt(value -> value).sum();
        this.drinks.clear();
        return sum;
    }
}

@FunctionalInterface
interface BillingStrategy {

    // below one of two methods provides implementation for this
    int getActPrice(int rawPrice);

    // normal change
    static BillingStrategy normalStrategy() {
        return rawPrice -> rawPrice;
    }

    // 50% discount
    static BillingStrategy happyHoursStrategy() {
        return rawPrice -> rawPrice/2;
    }

}