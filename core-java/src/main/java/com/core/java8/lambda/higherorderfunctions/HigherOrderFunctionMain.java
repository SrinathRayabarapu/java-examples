package com.core.java8.lambda.higherorderfunctions;

/**
 * Higher order functions either accepts a function, returns a functions or does the both
 */
public class HigherOrderFunctionMain {

    public static void main(String[] args) {
        IFactory<Integer> factory = createFactory(() -> Math.random() * 100, Double::intValue);
        Integer prodcut = factory.create();
        System.out.println("prodcut = " + prodcut);
    }

    public static <T, R> IFactory<R> createFactory(IProducer<T> producer, IConfigurator<T, R> configurator){
        return () -> {
            T product = producer.produce();
            return configurator.configure(product);
        };
    }

}