package com.core.exceptions;

import lombok.extern.slf4j.Slf4j;

/**
 * we can catch errors like below - but it's not good practice as per the java spec.
 */
@Slf4j
public class ThrowableMain {

    public static void main(String[] args) {

        try {
            throwError();
        } catch (Throwable e){
            log.info("Catched Error: ", e);
        }

    }

    private static void throwError() {
        throw new StackOverflowError("Custom runtime error");
    }
}
