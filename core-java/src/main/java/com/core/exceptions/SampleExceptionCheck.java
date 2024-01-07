package com.core.exceptions;

/**
 * day4 - prog2
 */
public class SampleExceptionCheck {
	public void mth1() {
		mth2();
		System.out.println("Caller from mth1");
	}

	public void mth2() {
		try {
			return;
		} catch (Exception e) {
			System.out.println("catch - mth2");
		} finally {
			System.out.println("finall - mth2");
		}
	}

	public static void main(String[] args) {
		SampleExceptionCheck check = new SampleExceptionCheck();
		check.mth1();
	}
}
