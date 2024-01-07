package com.core.exceptions;

public class ExamFailException extends Exception {
	/**
	 * Serial version UID
	 */
	private static final long serialVersionUID = 1L;

	String msg;

	public ExamFailException(String msg) {
		this.msg = msg;
	}

	@Override
	public String toString() {
		return "From MyException :" + msg;
	}
}