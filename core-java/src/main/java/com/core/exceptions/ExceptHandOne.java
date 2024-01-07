package com.core.exceptions;

/* 25.	Write a program that will generate exceptions of type NullPointerException, NegativeArraySizeException and IndexOutOfBoundsException. Record the catching of each exception by displaying the message stored in the exception object, and the stack trace record.*/

class ExceptHandOne {
	public static void main(String[] v) {
		int arr[] = new int[10];
		int arr1[] = new int[-10];
		String str = "";

		try {
			for (int i = 0; i <= 10; i++)
				arr[i] = i + 1;

			str = str.concat("abc");

			System.out.println("Str= " + str);

			System.out.println("First array Element is= " + arr[-1]);

			for (int i = 0; i < 10; i++)
				System.out.println(arr[i]);

		} catch (ArrayIndexOutOfBoundsException ae) {
			ae.printStackTrace();
		} catch (NegativeArraySizeException na) {
			na.printStackTrace();
		} catch (NullPointerException np) {
			np.printStackTrace();
		}
	}
}
