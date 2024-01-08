package com.reactor.services.exceptions;

public class MyCustomBusinessException extends Exception{
    public MyCustomBusinessException(Throwable cause) {
        super(cause);
    }
}
