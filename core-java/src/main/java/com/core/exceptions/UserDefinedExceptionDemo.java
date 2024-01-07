package com.core.exceptions;

/**
 * Assignment Day4 - Prog4
 */
public class UserDefinedExceptionDemo {
	public static void main(String[] args) {
		try {
			new Exam().testMarks(23);
		} catch (ExamFailException e) {
			System.out.println(e);
		}
	}
}

class Exam {
	public void testMarks(int marks) throws ExamFailException {
		if (marks < 35) {
			throw new ExamFailException("Oops,did you wrote exam good?");
		} else if (marks > 35) {
			System.out.println("Hurray, Passed ");
		}
	}
}