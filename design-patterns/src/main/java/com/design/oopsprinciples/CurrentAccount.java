package com.design.oopsprinciples;

public class CurrentAccount extends Account {
    @Override
    public double calculateInterest(double amount) {
        return (amount / 100) * 2;
    }
}
