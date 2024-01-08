package com.dpattern.behavioural.strategy.good;

import lombok.extern.slf4j.Slf4j;

/**
 * Changing the object behaviour at runtime
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