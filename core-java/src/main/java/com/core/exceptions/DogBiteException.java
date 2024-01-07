package com.core.exceptions;

public class DogBiteException extends Exception {

	private static final long serialVersionUID = 1L;
	String msg;

	public DogBiteException(String msg) {
		this.msg = msg;
	}

	@Override
	public String toString() {
		return "the exception is:" + msg;
	}
}
