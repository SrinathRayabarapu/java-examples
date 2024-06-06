package com.dpattern.behavioural.strategy.good;

import lombok.extern.slf4j.Slf4j;

/**
 * Changing the object behavior at runtime.
 *
 * 1. Create an Interface and have a common doOperation method
 * 2. Create a Context class which has this Interface and calls doOperation method
 * 3. Create bunch of concrete classes which implements Interface and implements behavior.
 * 4. At runtime you can pass in different concrete classes and see the behavior is different
 *
 * Ref: https://www.youtube.com/watch?v=-y5gssAvE7E
 */
@Slf4j
public class StrategyPatternMain {

    public static void main(String[] args) {

        Context context = new Context(new OperationAdd());
        log.info("10 + 5 = {}", context.executeStrategy(10, 5));

        context = new Context(new OperationSubtraction());
        log.info("10 - 5 = {}", context.executeStrategy(10, 5));

        context = new Context(new OperationMultiplication());
        log.info("10 * 5 = {}", context.executeStrategy(10, 5));

        context = new Context(new OperationDivide());
        log.info("10 / 5 = {}", context.executeStrategy(10, 5));
    }

}

interface Strategy{
    int doOperation(int x, int y);
}

class OperationAdd implements Strategy{
    @Override
    public int doOperation(int x, int y) {
        return x + y;
    }
}

class OperationSubtraction implements Strategy{
    @Override
    public int doOperation(int x, int y) {
        return x - y;
    }
}

class OperationMultiplication implements Strategy{
    @Override
    public int doOperation(int x, int y) {
        return x * y;
    }
}

class OperationDivide implements Strategy{
    @Override
    public int doOperation(int x, int y) {
        return x / y;
    }
}

class Context{
    private Strategy strategy;

    public Context(Strategy strategy){
        this.strategy = strategy;
    }

    public int executeStrategy(int x, int y){
        return strategy.doOperation(x, y);
    }
}