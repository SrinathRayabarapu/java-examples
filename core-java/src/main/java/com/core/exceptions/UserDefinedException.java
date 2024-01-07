package com.core.exceptions;

public class UserDefinedException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String msg;

	public UserDefinedException(String msg) {
		this.msg = msg;
	}

	@Override
	public String toString() {
		return "From MyException :" + msg;
	}
}