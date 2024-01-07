package com.core.exceptions;

/**
 * Assignment Day4 - Prog6
 */
public class InheritedExceptionHandling {
	public static void main(String[] args) {
		try {
			new ChildException();
		} catch (ExamFailException exception) {
			System.out.println(exception);
		}
	}
}

class ParentException {
	public ParentException() throws ExamFailException {
		throw new ExamFailException("ParentException");
	}
}

class ChildException extends ParentException {
	public ChildException() throws ExamFailException {
		System.out.println("ChildException");
	}
}