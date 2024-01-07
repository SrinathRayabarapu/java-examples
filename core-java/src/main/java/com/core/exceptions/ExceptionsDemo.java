package com.core.exceptions;

import java.util.ArrayList;
import java.util.List;

public class ExceptionsDemo {

	public static void main(String[] args) {
		indexOutOfBound();
		nullPointer();

        try {
            int i = 1 / Integer.parseInt(args[0]);
        } catch (ArithmeticException e) {
            System.out.println(e);
        } catch (ArrayIndexOutOfBoundsException ae) {
            System.out.println(ae);
        } catch (NumberFormatException ne) {
            System.out.println(ne);
        } finally {
            System.out.println("finally.....");
        }
        System.out.println("after exception....");

	}

	private static void nullPointer() throws NullPointerException {
		Student student = new Student();
		Integer id = null;
		try {
			//System.out.println("name:" + id.intValue());
			System.out.println("std name:" + student.getName().toUpperCase());
		} catch (Exception e) {
			System.out.println(e);
			System.out.println("id  is  null ");// customized error messages??			
		}

	}

	private static void indexOutOfBound() throws IndexOutOfBoundsException {
		List<String> names = new ArrayList<String>();
		try {
			names.add("Shubha");
			names.add("Anu");
			names.add("Priya");
			System.out.println("name @  index :" + names.get(3));

		} catch (Throwable e) {
			System.out.println("e" + e);
			throw new ArrayIndexOutOfBoundsException("hey dude");
		} finally {
			System.out.println("in  finally");
		}
	}
}
