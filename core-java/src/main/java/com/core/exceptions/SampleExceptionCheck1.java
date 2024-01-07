package com.core.exceptions;

/**
 * day4 - prog2
 */
public class SampleExceptionCheck1 {
	public void mth1() {
		mth2();
		System.out.println("Caller from mth1");
	}

	public void mth2() {
		try {
			System.exit(0);
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
