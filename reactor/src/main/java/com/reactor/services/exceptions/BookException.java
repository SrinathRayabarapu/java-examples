package com.reactor.services.exceptions;

public class BookException extends Exception{
    public BookException(String exceptionOccurredWhileFetchingBooks) {
        super(exceptionOccurredWhileFetchingBooks);
    }
}
