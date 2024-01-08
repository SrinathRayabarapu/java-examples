package com.design.oopsprinciples;

public class OnlineAccount extends Account {
    @Override
    public double calculateInterest(double amount) {
        return (amount / 100) * 5;
    }

    @Override
    public double withdraw(double amount) {
        System.out.println("Error: You cann't withdraw money!");
        return amount;
    }
}