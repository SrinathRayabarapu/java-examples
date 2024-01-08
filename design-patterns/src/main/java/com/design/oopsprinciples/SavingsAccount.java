package com.design.oopsprinciples;

public class SavingsAccount extends Account {
    @Override
    public double calculateInterest(double amount) {
        return (amount / 100) * 3;
    }
}
