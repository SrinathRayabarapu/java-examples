package com.core.java8.lambda.higherorderfunctions;

public interface IConfigurator<T, R> {
    R configure(T t);
}