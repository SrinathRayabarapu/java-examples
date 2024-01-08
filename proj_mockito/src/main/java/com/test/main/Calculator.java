package com.test.main;


public class Calculator {

    public int integerDivision(int dividend, int divisor) {
        if(divisor == 0){
            throw new ArithmeticException("Divisor is Zero");
        }
        return dividend / divisor;
    }

    public int integerSubtraction(int value1, int value2) {
        return value1 - value2;
    }

}
